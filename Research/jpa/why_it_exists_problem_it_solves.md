# Why it exists & What problem it solves

Early in Java development, developers had to use the low-level JDBC API to query databases. This required manually opening and closing connections, creating prepared statements, mapping data to and from objects and more.

To get rid of this boilerplate code, Object-Relational Mappers (ORMS) were created. This allowed developers to easily call high-level functions and directly save and retrieve object from the database.

However, many different ORM implementations appeared, all similar in purpose but slightly different in their details. To provide a common standard, the Java Persistence API (JPA) was introduced in 2006 as part of Java EE 5. JPA is a specification, not an implementation; it defines a consistent API that ORM frameworks (such as Hibernate or EclipseLink) can implement.

Later, when Java EE moved to the Eclipse Foundation, the name was changed to Jakarta Persistence.


## References
[Oracle Forums](https://forums.oracle.com/ords/apexds/post/why-jpa-what-s-the-point-6275)

[Jakarta EE](https://www.jakarta.ee)

[What is Java Persistence API (JPA)](https://medium.com/@mavidev/what-is-java-persistence-api-jpa-4af42dc326bc)