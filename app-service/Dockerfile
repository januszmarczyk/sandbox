FROM openjdk:11
WORKDIR /app
EXPOSE 8080
ARG JAR_FILE=/build/distributions/app-service-1.0-SNAPSHOT/lib/*.jar
COPY ${JAR_FILE} /app/lib/
ENTRYPOINT ["java","-jar","/app/lib/app-service-1.0-SNAPSHOT.jar"]