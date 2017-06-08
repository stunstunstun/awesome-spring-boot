

# <img src="http://stormpath.com/wp-content/uploads/2016/05/spring-boot-logo.jpg" width="50" align="absmiddle"/> Awesome Spring Boot

[![Build Status](https://travis-ci.org/stunstunstun/awesome-spring-boot.svg?branch=master)](https://travis-ci.org/stunstunstun/awesome-spring-boot.svg)
[![Wercker](https://img.shields.io/badge/spring--boot-1.5.3.RELEASE-brightgreen.svg)]()
[![Wercker](https://img.shields.io/badge/java-8-brightgreen.svg)]()
[![Wercker](https://img.shields.io/badge/gradle-3.5-brightgreen.svg)]()

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

#### What happended before?

Project | Build | Description |
---|---|----
[spring-jdbc-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-jdbc-example) | Maven | Integrating Spring Framework with JDBC
[spring-mybatis-example](https://github.com/stunstunstun/awesome-spring-boot/tree/master/spring-mybatis-example) | Maven | Integrating Spring Framework with myBatis

#### Afterwards Spring Boot works

Project | Build | Description |
---|---|----
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

## You can do it in yourself!

#### Spring Core
- http://vojtechruzicka.com/field-dependency-injection-considered-harmful/

#### Spring Boot Test
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-testing.html
- https://spring.io/blog/2016/04/15/testing-improvements-in-spring-boot-1-4
- https://docs.spring.io/spring/docs/current/spring-framework-reference/html/integration-testing.html
- http://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/test/mock/mockito/MockBean.html

#### Spring Data REST
- https://docs.spring.io/spring-data/rest/docs/current/reference/html/


#### Data Access
- https://spring.io/guides/gs/accessing-data-jpa/
- https://spring.io/guides/gs/accessing-data-mysql/
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html

#### Logging
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-logging.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-logging.html
- https://www.slideshare.net/whiteship/ss-47273947

#### HTTP Client
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-restclient.html

#### Embedded Servlet Containers
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-embedded-servlet-containers.html

#### Profiles
- https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-profiles.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-properties-and-configuration.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html

#### Actuator
- https://spring.io/guides/gs/actuator-service/
- https://github.com/spring-projects/spring-boot/tree/master/spring-boot-actuator
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-actuator.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-monitoring.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html 

#### Hotswapping
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-hotswapping.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-devtools.html
- https://spring.io/blog/2015/06/17/devtools-in-spring-boot-1-3

#### Deploy To AWS, Cloud Foundry
- https://docs.spring.io/spring-boot/docs/current/reference/html/howto-traditional-deployment.html
- https://docs.spring.io/spring-boot/docs/current/reference/html/cloud-deployment.html
