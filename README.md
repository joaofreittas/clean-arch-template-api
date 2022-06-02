# Template Clean Architecture API Spring Boot

## System

* [Java](https://openjdk.java.net/install/) : 17
* [Maven](https://maven.apache.org/download.cgi) : 3.8.4

## Frameworks

* [Spring-boot](https://spring.io/projects/spring-boot) : 2.7.0

## Architecture

#### 1.Clean Architecture
This microservice uses Clean Architecture, here's some good papers about it:
- [What is Clean Architecture?](https://medium.com/luizalabs/descomplicando-a-clean-architecture-cf4dfc4a1ac6)
- [Clean Architecture by Uncle Bob](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

![Clean architecture - Onion Architecture](./cleanarch/cleanarch.png?raw=true "Clean architecture - Onion Architecture")

## Setup


#### 1. Generate the target folder

At the root of the project run the following script:
```sh
$ mvn clean install -DskipTests
```

#### 2. Configure the database

You must configure your database.

use [MongoDB](##Mongo-DB)

### Mongo-DB

#### 2.2. Configure <b>mongoDB</b>

Inside the /docker folder, run the following command:

Production:
```sh
$ docker-compose up -d
```

Development:
```sh
$ docker-compose -f docker-compose-dev.yml up -d
```


## Environment variables

| Environment variable | Default value |
| ------ | ------ |
| DATABASE_URI | mongodb://localhost:27018 |
| DATABASE_NAME | database |

## Application


### Health

Open [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) to view it in the browser.


## Docker-compose commands

| Command | Description |
| ------ | ------ |
| docker-compose up -d | Create a new container in the background (-d) |
| docker-compose down | Remove an existing container |
| docker-compose start | Start an existing container |
| docker-compose stop | Pause an existing container |
