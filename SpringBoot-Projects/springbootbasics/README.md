# 1.Quick Start

## 1.1 Environment Check-Point
    - JDK 17 
    - Spring Boot 3 
    - Any IDE like Intellij

## 1.2 Simple Rest Controller 
    check quick start project for reference

## 1.3 Goals of Spring
    - Lightweight Development with Java POJOs(Plain Old Java Objects)
    - Dependecy injection to promte loose coupling 
    - Minimize boilerplate Java Code
## 1.4 Core container
    - It manages how beans are created, It has a been factory to creating the beans
    - It can read config files for setting properties and dependencies 
    - The context here is really a spring container for holding the beans in memory
## 1.5 AOP 
    - Application wide services like logging,secuity,transactions,instrumentation
    - You will simply need to add configuration and then it will be applied to your application 
## 1.6 Data Access layer
    - Spring provide helper classes to access a database using jdbc and it will reduce 50% of your code
    - ORM(Object Relational Mapping) allows you to connect with hibernate and JPA 
## 1.7 Maven
    - Project Management Tool 
    - Without maven we should download the Jar files and add it to class path
    - With Maven , Maven will go out and download the Jar Files for those projects for you
    - Maven will Search first in Your Local Repository if it is not available in local
    - Then Maven will go and find it in central repository and download it to your local repository
    - When I am running the application maven will handle build and class path for us
    - You can run and build a project with minimal local configuration


nstead of downloading the jar and adding to class path maven does it
maven first checks in your local repository and if it is not there it goes to
maven central repository and gets it 