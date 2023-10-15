# Apache Kafka

Apache Kafka est une plateforme de streaming de données open source, initialement développée par LinkedIn et maintenant gérée par la Apache Software Foundation. Kafka est conçu pour la gestion de flux de données 
en temps réel, le traitement des événements et le transport de données entre différentes applications et systèmes. Il est largement utilisé dans le domaine de l'ingestion, du traitement et de la diffusion de données 
en temps réel.

### Broker Kafka :
	Les brokers Kafka sont des serveurs qui stockent et gèrent les flux de données. Ils sont responsables de la réception, de la persistance et de la diffusion des messages. Un cluster Kafka est composé de plusieurs brokers pour la redondance et la tolérance aux pannes.
	
	
### Topic :
	Un topic Kafka est une catégorie ou un canal de diffusion pour les messages. Les producteurs envoient des messages vers des topics, et les consommateurs lisent ces messages à partir des topics auxquels ils sont abonnés. Les topics permettent de catégoriser les messages en fonction de leur contenu.
	
	
### Producteur Kafka :
	Les producteurs Kafka sont des applications ou des composants responsables de la publication de messages vers des topics. Ils envoient des messages au broker Kafka, qui les stocke et les diffuse aux consommateurs.
	
	
### Consommateur Kafka :
	Les consommateurs Kafka sont des applications ou des composants qui lisent les messages à partir des topics auxquels ils sont abonnés. Ils peuvent traiter les messages en temps réel ou les stocker dans des systèmes de traitement ou de stockage de données.
	
	
### Partition :
	Les topics Kafka sont divisés en partitions, qui sont des unités de stockage et de distribution des messages. Les partitions permettent une distribution parallèle des messages et un traitement évolutif.
	
	
### Groupes de consommateurs :
	Les consommateurs Kafka peuvent être regroupés en groupes de consommateurs. Chaque groupe traite les messages d'un topic donné de manière parallèle. Cela permet de répartir la charge de traitement des messages.
	
	
### ZooKeeper :
	Bien que Kafka ait réduit sa dépendance à ZooKeeper dans les versions récentes, ZooKeeper était auparavant utilisé pour la gestion de la configuration et la coordination des brokers Kafka au sein d'un cluster.
	
	
### Retention :
	Kafka conserve les messages pendant une certaine période, appelée rétention, ce qui permet aux consommateurs de rattraper leur retard sur les messages passés.


# Kafka a quatre API principaux:

- Producer API: Permet à une application de publier un flux d'enregistrements vers un ou plusieurs Topics (Sujets) Kafka.
- Consumer API: Permet à une application de s'abonner à un ou plusieurs Topics et de traiter le flux d'enregistrements qui lui sont transmis.
- Streams API: Permet à une application d'agir en tant que processeur de flux, en Consommant un flux d'entrée provenant d'un ou plusieurs Topics Transformant efficacement les flux d'entrée en flux de sortie Produisant un flux de sortie vers un ou plusieurs Topics en sortie.
- Connector API: Permet de créer et d'exécuter des producteurs ou des consommateurs réutilisables qui connectent des topics Kafka à des applications ou des systèmes de données existants. Par exemple, un connecteur vers une base de données relationnelle peut capturer chaque modification apportée à une table.

# Utilisation KAFKA

![image](https://github.com/salma-SABROU/KAFKA-TP1/assets/129564311/ec6f117f-a501-4126-a357-294ad36d53fe)

# Docker 
L'utilisation de Docker avec Apache Kafka offre une solution efficace et flexible pour le déploiement et la gestion des clusters Kafka. En encapsulant les composants de Kafka, tels que les brokers, les producteurs et les consommateurs, dans des conteneurs Docker, on bénéficie d'une isolation des environnements, d'une portabilité accrue et d'une gestion simplifiée. Cette approche permet de déployer rapidement des clusters Kafka, de les dimensionner en fonction des besoins, et de les mettre à l'échelle de manière dynamique. De plus, Docker facilite la gestion des dépendances et des mises à jour, tout en garantissant la cohérence entre les environnements de développement, de test et de production. En résumé, l'utilisation de Docker avec Apache Kafka offre une solution agile et robuste pour la mise en place de systèmes de traitement de données en temps réel, améliorant ainsi la gestion des flux de données dans des environnements complexes et dynamiques.

### l'utilisation du Docker 
  - docker-compose up
![image](https://github.com/salma-SABROU/KAFKA-TP1/assets/129564311/985669b9-c075-482b-b975-bd8e9830c90f)

  - docker exec --interactive --tty broker kafka-console-consumer --bootstrap-server broker:9092 --topic R2
![image](https://github.com/salma-SABROU/KAFKA-TP1/assets/129564311/7739ef96-859b-40a1-83ab-c82a86d24ffb)

  - docker exec --interactive --tty broker kafka-console-producer --bootstrap-server broker:9092 --topic Test2
![image](https://github.com/salma-SABROU/KAFKA-TP1/assets/129564311/f8d7822b-c25b-40ab-9701-f7111f17dc68)

# TP :
![image](https://github.com/salma-SABROU/KAFKA-TP1/assets/129564311/88096c14-8308-4012-8fdd-6d6068b00075)

![image](https://github.com/salma-SABROU/KAFKA-TP1/assets/129564311/bbdbc0f5-fddf-46ce-b423-cca5323ff442)

