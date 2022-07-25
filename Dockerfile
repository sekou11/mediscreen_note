FROM openjdk:8-jdk-alpine
COPY target/*.jar mediscreen_note-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker","/mediscren_note-0.0.1-SNAPSHOT.jar"]