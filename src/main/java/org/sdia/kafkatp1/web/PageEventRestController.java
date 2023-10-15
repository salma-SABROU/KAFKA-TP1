package org.sdia.kafkatp1.web;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Windowed;
import org.apache.kafka.streams.state.*;
import org.sdia.kafkatp1.entities.PageEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;

@RestController
public class PageEventRestController {
    @Autowired
    private StreamBridge streamBridge;
    @Autowired
    private InteractiveQueryService interactiveQueryService;

    @GetMapping("/publish/{topic}/{name}")
    public PageEvent publish(@PathVariable String topic,@PathVariable String name){
        PageEvent pageEvent=new PageEvent(name,Math.random()>0.5?"U1":"U2",new Date(),new Random().nextInt(9000));
        streamBridge.send(topic,pageEvent);

        return pageEvent;
    }

    @GetMapping(value = "/analytics",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String,Long>> analytics(){
        return Flux.interval(Duration.ofSeconds(5))
                .map(seq->{
                    Map<String,Long> stringLongMap=new HashMap<>();
                    ReadOnlyWindowStore<String, Long> windowStore = interactiveQueryService.getQueryableStore("page-count", QueryableStoreTypes.windowStore());
                    Instant now=Instant.now();
                    //Instant from=now.minusMillis(50000);
                    Instant from = now.minusSeconds(50); // Par exemple, 50 secondes en arrière par rapport à "now"

                    KeyValueIterator<Windowed<String>,Long> fetchAlls = windowStore.fetchAll(from,now);
                    if(fetchAlls.hasNext()){
                        System.out.println("************************* fetchAlls is not vide *******************************");
                        while (fetchAlls.hasNext()){
                            KeyValue<Windowed<String>, Long> next = fetchAlls.next();
                            stringLongMap.put(next.key.key(),next.value);
                        }
                    }else{
                        System.out.println("************************* fetchAlls is vide *******************************");
                    }

                    return stringLongMap;
                });
    }

    @GetMapping(value = "/analytics/{page}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Map<String,Long>> analyticsPage(@PathVariable String page){
        return Flux.interval(Duration.ofSeconds(5))
                .map(seq->{
                    Map<String,Long> stringLongMap=new HashMap<>();
                    ReadOnlyWindowStore<String, Long> windowStore = interactiveQueryService.getQueryableStore("page-count", QueryableStoreTypes.windowStore());
                    Instant now=Instant.now();
                    Instant from = now.minusSeconds(50); // Par exemple, 50 secondes en arrière par rapport à "now"

                    //KeyValueIterator<Windowed<String>,Long> fetchAlls = windowStore.fetchAll(from,now);
                    WindowStoreIterator<Long> fetch = windowStore.fetch(page,from,now);
                    while (fetch.hasNext()){
                        KeyValue<Long, Long> next = fetch.next();
                        stringLongMap.put(page,next.value);
                    }

                    return stringLongMap;
                });
    }

}
