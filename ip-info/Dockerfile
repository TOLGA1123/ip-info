#OpenJDK base image
FROM openjdk:17

WORKDIR /app

COPY target/ip-info-0.0.1-SNAPSHOT.jar ip-info.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/ip-info.jar"]
