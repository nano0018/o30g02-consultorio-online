FROM amazoncorretto:11-al2023-jdk
MAINTAINER nano0018
ARG WAR_FILE=target/*.war
COPY ${WAR_FILE} finalProyect-0.0.1-SNAPSHOT.war
ENTRYPOINT ["java", "-jar", "/finalProyect-0.0.1-SNAPSHOT.war"]