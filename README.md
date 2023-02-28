## ms-kafka-replay
This is a prototype service which listens to error topics in kafka which are used when messages fail to send to their
main topic and are re-routed. Then they will be persisted into a mongodb database.

## Dependencies
- Java 17
- Gradle
- Kafka
- MongoDB

## Endpoints
### kafka-replay

Service will be hosted on localhost:8090.\
Access endpoints from Open API: [here](http://localhost:8090/swagger-ui/)
