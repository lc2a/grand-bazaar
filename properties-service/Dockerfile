FROM openjdk:8-jdk-alpine

WORKDIR /app
ADD build/libs/properties.jar properties.jar

EXPOSE 8080

CMD java -Dserver.port=8080 -jar /app/properties.jar
