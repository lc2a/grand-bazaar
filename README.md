# Grand Bazaar

A shallow microservices implementation of a marketplace with a few features such as
property search, user notifications on new property matching a set of criteria, etc.
The approach doesn't leverage CQRS or Event Sourcing.

Technologies used:

- Spring Boot
- Rabbit MQ
- MongoDB
- Docker
- Kubernetes Helm charts

### Build

Each service is independent and all services are built with Gradle coincidentally, hence:

```sh
cd users-service && ./gradlew build && cd ..
cd properties-service && ./gradlew build && cd ..
cd notifications-service && ./gradlew build && cd ..
```
