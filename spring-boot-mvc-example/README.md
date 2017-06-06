
You can access from the browser via the address below

> http://localhost:8080/

#### APIs Summary

Sets for RESTful API

```
GET /users 
POST /users
GET /users/{id}
PUT /users/{id}
DELETE /users/{id}
```

#### H2 Database Console

You can manage H2 Database by Console pages

```
GET /h2-console
```

## Test

```
$ gradlew test
```

## Build

```
$ gradlew assemble
```

#### Running as a packaged application

```
$ java -jar build/libs/spring-boot-mvc-example-0.0.1-SNAPSHOT.war
```

#### Using Spring Boot Plugin

```
$ gradlew bootRun
```

## Deploy

You can create war file to deploy like below

```
$ gradlew bootRepackage
```



