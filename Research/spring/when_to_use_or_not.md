# When to use (Pros)

When trying to put it into as few words as possible, Spring should be used within large-scale enterprise applications. To further explain and give more reasons, the support of microservice architectures is another big factor when it comes to choosing Spring. Especially when configuration of microservices becomes an issue and the application grows in complexity (HiQ, n.d.; Baeldung, n.d.). However, this is not the only reason. Spring might also be a good option when the developer team already has experience with it, or Java in general. Depending on the project, this prior experience might outweigh other considerations even though the project might not be expected to scale into an enterprise application.

Another reason to use it can be its well-documented and proven ecosystem. There are a lot of different out-of-the-box solutions which Spring Boot offers that speed up developer time (Baeldung, n.d.; Spring, n.d.), and the agreed-upon standards of Spring make it so that every Spring developer should understand the basics of whatever Spring application they are joining (HiQ, n.d.).

# When NOT to use (Cons)

Spring Boot should not be used in small projects or projects in which it is certain that the project won’t grow beyond a certain complexity and size (HiQ, n.d.; Baeldung, n.d.). When microservices are not needed, Spring Boot might also be overkill. However, you cannot say that definitely: if a developer group all has prior experience in Java, it might still be a nice solution. It really depends on requirements plus preferences of the developer group.

- Spring Boot shines when used within big applications. The reason for this is also mostly what makes it not a good fit for smaller projects. There is a lot of implementation and functionality suited for large applications which a small one does not need, while they introduce the following problems:

  - **Complexity Creep**  
    - Keeping track of how the code works can be quite a challenge due to the layers of abstractions, especially once the project grows.

  - **Complexity of Spring and Boot**  
    - Spring itself introduces several layers of abstraction for different aspects of the software such as JPA and Spring Data JPA. This can be confusing for developers and takes time to fully understand — it is an investment that usually pays off.

(HiQ, n.d.; Baeldung, n.d.)

## Examples

- Sofa Project for displaying a campus map, where most of the technical difficulty comes from digitizing a map and displaying it in the frontend → not a good fit, as it is probably overkill for such a project.

- New project for managing bank accounts using a microservice architecture, which is expected to grow significantly in the future → might be a great fit (it still depends on the project’s requirements as always).

---

## References

Baeldung (June 18, 2025) *Why Choose Spring Boot?* Available at: <https://www.baeldung.com/spring-why-to-choose> (Accessed: 13 November 2025).

HiQ (n.d.) *Spring Boot, Quarkus or Micronaut? Your Guide Through the Java Framework Jungle.* Available at: <https://hiq.se/en/insight/spring-boot-quarkus-or-micronaut-your-guide-through-the-java-framework-jungle/> (Accessed: 13 November 2025).

Spring (n.d.) *Spring Boot Features and Documentation.* Available at: <https://spring.io/projects/spring-boot> (Accessed: 13 November 2025).
