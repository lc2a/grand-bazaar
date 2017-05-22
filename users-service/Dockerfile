FROM openjdk:8-jdk-alpine

WORKDIR /app
ADD build/libs/users.jar users.jar

EXPOSE 8080

CMD java -Dserver.port=8080 -jar /app/users.jar
