# Alternatives to JPA

## Non-JPA Object-Relational Mappers
These frameworks provide ORM functionality similar to JPA but without relying on the JPA specification.

- **Ebean ORM**: Sessionless ORM tool with a simpler API for persisting, still supports JPA annotations for defining entities   

- **Apache Cayenne**: Open Source ORM and persistence framework with a visual modeler and support for complex object graphs.  

---

## SQL Mappers / Query Builders
Frameworks that let developers work closer to SQL while still providing convenient APIs for mapping results.

- **JDBI**: Open Source library that uses lambda expressions and reflection to create a higher level interface than JDBC.
- **jOOQ**: Type-safe SQL query builder that generates Java code from your database schema, allowing native java-like database querying.  

---

## Low-Level APIs
Direct or minimal abstractions over database access.

- **JDBC**: Standard Java API for relational database access.

- **R2DBC**: Reactive alternative to JDBC for non-blocking database access.

---

## Non-Relational Persistence
Used when working with NoSQL or non-relational databases, often through Spring Data modules.

- **Spring Data MongoDB**: Provides integration and repositories for MongoDB.  

- **Spring Data Redis**: Provides integration and repositories for Redis.  

---

## When to Use Which

| Alternative | When to use |
|------------|--------------------|
| Non-JPA ORMS | You want an ORM without full JPA complexity |
|SQL Mappers / Query Builders | You want to work closer with the SQL but still want the convenience of mapping to objects |
| Low-Level APIs | You need direct database access without abstractions |
| Non-Relational Persistence | You are using non-relational databases |
---

## References
[Ebean](https://ebean.io/)

[Ebean compare with JPA](https://ebean.io/architecture/compare-jpa)

[Ebean](https://www.baeldung.com/ebean-orm)

[Cayenne Apache](https://cayenne.apache.org/)

[Cayenne Apache](https://www.baeldung.com/apache-cayenne-orm)

[JDBI](https://jdbi.org/)

[JDBI](https://www.baeldung.com/jdbi)

[JOOQ](https://www.jooq.org/)

[JOOQ](https://www.baeldung.com/jooq-intro)

[JDBC](https://www.geeksforgeeks.org/java/introduction-to-jdbc/)

[Alternatives for JPA](https://javanexus.com/blog/unlocking-alternatives-jpa-hibernate-short)
[ORM tools to know](https://www.techtarget.com/searchsoftwarequality/tip/Java-ORM-tools-to-know)
[Norm4j](https://medium.com/%40cedric.nanni/norm4j-a-sql-first-high-performance-alternative-to-jpa-4d96bdf8ecbd)

[Spring Data Mongodb](https://spring.io/projects/spring-data-mongodb)

[Spring Data Redis](https://spring.io/projects/spring-data-redis)

[R2DBC](https://r2dbc.io/)
