# Awesome Spring Boot

A curated list of amazingly examples of Spring Boot, resources and shiny things.


## Contents

<details>
<!-- toc -->

- [Tutorials](#tutorials)
- [DevOps](#devops)
  - [Prerequisite](#prerequisite)
  - [Test](#test)
  - [Build](#build)
  - [Run](#run)
- [Spring Boot Features](#spring-boot-features)

<!-- tocstop -->
</details>

## Tutorials

Tutorials of how Spring Boot works!

Project | Build | Description |
---|---|----
[spring-jdbc-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-jdbc-example) | Maven | Integrating Spring Framework with JDBC
[spring-mybatis-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-mybatis-example) | Maven | Integrating Spring Framework with myBatis
[spring-boot-jdbc-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-boot-jdbc-example) | Gradle | Integrating Spring Boot with JDBC
[spring-boot-jpa-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-boot-jpa-example) | Gradle | Integrating Spring Boot with JPA
[spring-boot-mybatis-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-boot-mybatis-example)| Gradle | Integrating Spring Boot with myBatis
[spring-boot-mybatis-multi-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-boot-mybatis-multi-example) | Gradle | Integrating Spring Boot with multiple datasources
[spring-boot-mvc-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-boot-mvc-example) | Gradle | Integrating Spring Boot with Spring MVC
[spring-boot-gradle-multi-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-jdbc-example) | Gradle | Multiple modules structures in Gradle

#### Download

If you wanna try `spring-boot-jdbc-example`, You need to move to ROOT directory of that example first.

```
$ git clone https://github.com/stunstunstun/awesome-spring-boot.git
$ cd awesome-spring-boot/spring-boot-mybatis-example
```

## DevOps

#### Prerequisite

Your operating system must have the JDK installed and it's recommended that you install the IDE to look up the source code.

#### Test

Check the test case with the `@Test` annotation.

```
$ gradlew test 
```

#### Build

Build the project and create executable jar and war files.

```
$ gradlew assemble 
```

It doesn't work? You should check execution permission.

```
$ chmod +x gradlew
```

#### Run

An example with spring-web-starter can be connected by Web Browser

- localhost:8080

```
$ gradlew bootRun
```

## Spring Boot Features

#### Bootstrap By Spring Boot CLI

`Install Spring Boot CLI`
```
$ brew tap pivotal/tap
$ brew install springboot
$ spring --version
```

`Create Project`
```
$ spring init --build=gradle --java-version=1.8 --dependencies=data-jpa spring-boot-jpa-example
```

#### Spring Boot Test

#### Data Access

#### Logging

#### HTTP Client

#### Embedded Servlet Containers

#### Profiles

#### Actuator

#### Hotswapping

#### Deploy To AWS, Cloud Foundry
