# Properties service

## Build and Run

```sh
./gradlew clean build
docker-compose up --build
```

## Development tools

```sh
# Open RabbitMQ Management console
open http://localhost:15672/
```

```sh
# Download MongoDB Compass UI
wget https://downloads.mongodb.com/compass/mongodb-compass-1.6.1-darwin-x64.dmg
```

## Code Quality

- PMD rules
- Checkstyle rules
- Jacoco code coverage with quality gate

```sh
# Open Spock test report
open build/spock-reports/index.html
```

```sh
# Open Jacoco test coverage report
open build/reports/jacoco/test/html/index.html
```
