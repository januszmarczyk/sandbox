FROM openjdk:11-jre-slim

WORKDIR /opt
EXPOSE 8090

COPY build/install/app-statistics /opt
COPY entrypoint.sh /

ENTRYPOINT ["/entrypoint.sh", "app-statistics-1.0-SNAPSHOT.jar"]