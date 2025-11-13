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

## Examples

Sofa Project for disaplying a campus map. Where most of the technical difficulty comes from digitilizing a map and displaying it in the frontend. -> Not a good fit as it is probably overkill for such a project.

New project for managing Bank accounts using a Microservice Architecture  which is expected to grow significantely in the future -> Might be a great fit (it still depends on the projects requirements as always)



--

References

HiQ (n.d.) Spring Boot, Quarkus or Micronaut? Your Guide Through the Java Framework Jungle. Available at: https://hiq.se/en/insight/spring-boot-quarkus-or-micronaut-your-guide-through-the-java-framework-jungle/
 (Accessed: 13 November 2025).

Baeldung (n.d.) Why Choose Spring Boot? Available at: https://www.baeldung.com/spring-why-to-choose
 (Accessed: 13 November 2025).
