FROM openjdk:11
COPY ./build/app-service-1.0-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar app-service-1.0-SNAPSHOT.jar --envname=dev