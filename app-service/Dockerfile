FROM openjdk:11-jre-slim

WORKDIR /opt
EXPOSE 8080

COPY build/install/app-service /opt
COPY entrypoint.sh /

ENTRYPOINT ["/entrypoint.sh", "app-service-1.0-SNAPSHOT.jar"]