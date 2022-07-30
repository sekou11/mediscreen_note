FROM openjdk:8
ADD target/mediscreen_note-0.0.1-SNAPSHOT.jar mediscreen_note-0.0.1-SNAPSHOT.jar
EXPOSE 8702
ENTRYPOINT ["java","-jar","mediscreen_note-0.0.1-SNAPSHOT.jar"]


