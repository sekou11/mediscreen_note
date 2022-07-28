# mediscreen_note

Technology and Prerequisites


JAVA 8 JDk


Springboot

MongoDB


Maven


Docker


Installing


Install Java: - https://www.oracle.com/fr/java/technologies/javase-downloads.html

Install Maven - https://maven.apache.org/install.html

Intall MongoDB: - https://docs.mongodb.com/manual/administration/install-community/

Install Docker: - https://www.docker.com/products/docker-desktop

MicroServices Details

Port:8702  Patient histoeiq


This microservice allow to process CRUD operations in order to manage DoctorNote about Patient. 

To do this, the API comunicates with a MONGODB database.

Run Application

Install the prerequisites and Technology list above.

1️⃣ Build .jar

Open your terminal and go to each microServices directory and run this command :


▶️ SYNTAX = mvn clean package


thanks to this command you build .jar


you have to build jar to run docker-compose.


Docker


Open your terminal and go to the directory containing docker-compose.yml


▶️ SYNTAX = docker-compose up -d
