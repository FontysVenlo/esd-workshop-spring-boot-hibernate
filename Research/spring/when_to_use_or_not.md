# When to use (Pros)

- Large Scale enterprise applications
  - Spring Boot was exactly build for this purpose
- Microservice Architecture
  - Spring Boot supports Microservices nicely
- OR when configuration of Microservices becomes an issue (growing complexity)

# When NOT to use (Cons)

Spring Boot should not be used in small projects or projects in which it is certain that the project wont grow beyond a certain complexity and size. When Microservices are not needed Spring Boot might also be overkill.

- Spring Boot shines when used within Big Applications. The reason for this is also mostly what makes it not a good fit for smaller projects. There is a lot of implementation and functionality suited for large applications which a small one do not need while they introduce the following problems:

  - Complexity Creep
    - Keeping track of how the code works can be quite a challenge due to   the layers of abstractions. Especially once the project grows.
  - Complexity of Spring and Boot
    - Spring itself already introduces several layers of abstraction for   different aspects of the Software such as JPA, Spring JPA. This can be quite confusing for developers and takes time to really understand. -> It is an investment that usually pays off

##

--

References
[REFERENCE 1](www..nl)
[spring-boot-quarkus-or-micronaut-your-guide-through-the-java-framework-jungle](https://hiq.se/en/insight/spring-boot-quarkus-or-micronaut-your-guide-through-the-java-framework-jungle/)
