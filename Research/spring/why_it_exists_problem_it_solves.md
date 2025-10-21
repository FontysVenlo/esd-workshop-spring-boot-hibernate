# Why it exists


# Problems that Spring solves

Java, like almost all programming languages has some issues or drawbacks which come with it. the Jakarta EE (formerly kwown as Java Platform, Enterprise Edition / Java EE) tried to solve those issues, especially as the name suggests for enterprise level projects. However it brought its own problems and struggles which Spring tries to solve.

#### Sources

[Spring overview](https://docs.spring.io/spring-framework/reference/overview.html)

## Application Context and dependency injection

A common problem in java is the managment of object instances within an application. If ONE class needs an instance of ONE other class that is no problem but once an application grows, dependencies and object instances become very intertwined and complex.

### Business Classes

Some Classes such as business classes do not need to be instantiated multiple times. Lets say we have an application for one class ATM which represents ONE single ATM machine. Within this class all requests to withdraw and deposit money is handled. It does not contain any data, instead it is purely functional. This Class does not need to be instantiated multiple times. Instead the reference to that class should be shared across the application whenever it is needed. Especially for this case the singleton pattern was created however creating and maintaining this pattern can be a lot of work - This is when Spring comes into play

#### Sources

[Spring Overview](https://docs.spring.io/spring-framework/reference/overview.html)

### Application Context

Instead of manually managing those business classes, it is possible to define these classes to spring which is then able to manage them on its own. (Their dependencies and its shared state) Spring uses [dependency Injection](https://en.wikipedia.org/wiki/Dependency_injection) for this. Each object/class defines what dependency it needs and Spring provides it automatically.

#### Sources

- [dependency Injection](https://en.wikipedia.org/wiki/Dependency_injection)

-

## Database Access and JDBC

JDBC is widely known as being not that nice to work with. (also from personal experience) This is why Spring Abstracts the interaction with JDBC and makes it so that the user does not have to interact with it directly, while also providing essential database access mechanics such as transaction managment queriyng and so on.

Sources:

[JDBC](https://www.geeksforgeeks.org/java/introduction-to-jdbc/)

## Spring MVC (Web framework)

Spring MVC enables java to act as a server for Webservices and offers essential functionalties such as defining REST APIs or offering Dynamic web page loading. It handles HTTP requests, provides controllers for routing which makes it quite powerfull and simplifies many coding challenges that a programmer might face when creating these functionalites themselves using plain Java.


## 


--

References
[What is the Spring framework really all about?](https://www.youtube.com/watch?v=gq4S-ovWVlM)