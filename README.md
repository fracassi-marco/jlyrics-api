# JLyrics Api

JLyrics Api is a simple project based on Spring Boot and Java. 
It's goal is to explore the testing strategies related to a Spring Boot web application written in Java.
It provide a set of examples for:
* acceptance tests
* external rest service integration tests
* controller unit tests
* databse integration tests

## Getting Started

Clone the repository:

```
git clone https://github.com/fracassi-marco/jlyrics-web.git
cd lyrics-web
```

Run the application:

```
mvn spring-boot:run
```

Open browser:

```
http://localhost:8080/lyrics/search?author=U2&title=Pride
```

### Prerequisites

You must have Maven

## Running the tests

```
mvn test
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **[Marco Fracassi](https://github.com/fracassi-marco)**

## License

This project is licensed under the GNU GENERAL PUBLIC LICENSE Version 3 - see the [LICENSE](LICENSE) file for details