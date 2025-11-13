# Why it exists & What problem it solves

Early in Java development, developers had to use the low-level JDBC API to query databases. This required manually opening and closing connections, creating prepared statements, mapping data to and from objects and more (Mihalcea, 2020; Oracle Forums, 2008).

To get rid of this boilerplate code, Object-Relational Mappers (ORMS) were created. This allowed developers to easily call high-level functions and directly save and retrieve object from the database (Mavidev, 2024; Mihalcea, 2020).

However, many different ORM implementations appeared, all similar in purpose but slightly different in their details. To provide a common standard, the Java Persistence API (JPA) was introduced in 2006 as part of Java EE 5. JPA is a specification, not an implementation; it defines a consistent API that ORM frameworks (such as Hibernate or EclipseLink) can implement (Mihalcea, 2020).

Later, when Java EE moved to the Eclipse Foundation, the name was changed to Jakarta Persistence (Chandra, 2024).


## References
Chandra, P. (24 September 2024) From javax to jakarta namespace: What it Means for WaveMaker Apps Available at: https://docs.wavemaker.com/learn/blog/2024/09/24/javax-to-jakarta/ [Accessed 13 Nov. 2025].

Mavidev. (2 September 2024) What is Java Persistence API (JPA)? Available at: https://medium.com/@mavidev/what-is-java-persistence-api-jpa-4af42dc326bc [Accessed 13 Nov. 2025].

Mihalcea, V. (16 September 2020) Why and when you should use JPA. Available at: https://vladmihalcea.com/why-and-when-use-jpa/ [Accessed 13 Nov. 2025].

Oracle Forums (1 January 2008) Why JPA? What's the Point? Available at: https://forums.oracle.com/ords/apexds/post/why-jpa-what-s-the-point-6275 [Accessed 13 Nov. 2025].
