
You can access from the browser via the address below

> http://localhost:8080/

#### APIs Summary

```
GET /users 
GET /users/{id}
POST /users
PUT /users/{id}
DELETE /users/{id}
```

#### H2 Database Console

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
$ java -jar build/libs/spring-boot-mvc-example.jar
```

#### Using Gradle Plugin

```
$ bash gradlew bootRun
```

## Deploy

You can make war file to deploy like below

```
$ gradle bootRepackage
```



