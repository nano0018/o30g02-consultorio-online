# FROM amazoncorretto:17.0.6-al2023
# MAINTAINER nano0018
# ARG WAR_FILE=target/*.war
# COPY ${WAR_FILE} finalProyect-0.0.1-SNAPSHOT.war
# ENTRYPOINT ["java", "-jar", "/finalProyect-0.0.1-SNAPSHOT.war"]
# EXPOSE 8080

#
# Build stage
#
FROM maven:3.8.2-jdk-11 AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:11-jdk-slim
COPY --from=build /target/finalProyect-0.0.1-SNAPSHOT.war demo.war
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","demo.war"]