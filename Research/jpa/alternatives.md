# Alternatives to JPA

## Non-JPA Object-Relational Mappers
These frameworks provide ORM functionality similar to JPA but without relying on the JPA specification.

- **Ebean ORM**: Sessionless ORM tool with a simpler API for persisting, still supports JPA annotations for defining entities (Ebean, n.d.-a; Ebean, n.d.-b; Hombergs, 2018)   

- **Apache Cayenne**: Open Source ORM and persistence framework with a visual modeler and support for complex object graphs (Apache Cayenne, n.d.; Bealdung, 2024).  

---

## SQL Mappers / Query Builders
Frameworks that let developers work closer to SQL while still providing convenient APIs for mapping results.

- **JDBI**: Open Source library that uses lambda expressions and reflection to create a higher level interface than JDBC (Jdbi, n.d.; Stalla, 2024).
- **jOOQ**: Type-safe SQL query builder that generates Java code from your database schema, allowing native java-like database querying (Baeldung, 2025; jOOQ, n.d.).  

---

## Low-Level APIs
Direct or minimal abstractions over database access.

- **JDBC**: Standard Java API for relational database access (Geeksforgeeks, 2025).

- **R2DBC**: Reactive alternative to JDBC for non-blocking database access (R2DBC, n.d.).

---

## Non-Relational Persistence
Used when working with NoSQL or non-relational databases, often through Spring Data modules.

- **Spring Data MongoDB**: Provides integration and repositories for MongoDB (Spring, n.d.-a).  

- **Spring Data Redis**: Provides integration and repositories for Redis (Spring, n.d.-b).  

---

## When to Use Which

| Alternative | When to use |
|------------|--------------------|
| Non-JPA ORMS | You want an ORM without full JPA complexity |
| SQL Mappers / Query Builders | You want to work closer with the SQL but still want the convenience of mapping to objects |
| Low-Level APIs | You need direct database access without abstractions |
| Non-Relational Persistence | You are using non-relational databases |
---

## References

Apache Cayenne (n.d.) Your ORM superpower. Available at: https://cayenne.apache.org/ [Accessed 13 Nov. 2025]

Bealdung (8 January 2024) Introduction to Apache Cayenne ORM. Available at: https://www.baeldung.com/apache-cayenne-orm [Accessed 13 Nov. 2025]

Baeldung (26 March 2025) Getting Started with jOOQ. Available at: https://www.baeldung.com/jooq-intro [Accessed 13 Nov. 2025]

Ebean (n.d.-a) Ebean ORM. Available at: https://ebean.io/ [Accessed 13 Nov. 2025]

Ebean (n.d.-b) Architecture: Compare JPA . Available at: https://ebean.io/architecture/compare-jpa [Accessed 13 Nov. 2025]

Geeksforgeeks (15 September 2025) JDBC (Java Database Connectivity). Available at: https://www.geeksforgeeks.org/java/introduction-to-jdbc/ [Accessed 13 Nov. 2025]

Hombergs T. (14 October 2018) Guide to Ebean ORM. Available at: https://www.baeldung.com/ebean-orm [Accessed 13 Nov. 2025]

Jdbi (n.d.) Introduction to Jdbi 3. Available at: https://jdbi.org/#_introduction_to_jdbi_3 [Accessed 13 Nov. 2025]

jOOQ (n.d.) jOOQ. Available at: https://www.jooq.org/ [Accessed 13 Nov. 2025]

R2DBC (n.d.) R2DBC. Available at: https://r2dbc.io/ [Accessed 13 Nov. 2025]

Spring (n.d.-a) Spring Data MongoDB. Available at: https://spring.io/projects/spring-data-mongodb [Accessed 13 Nov. 2025]

Spring (n.d.-b) Spring Data Redis. Available at: https://spring.io/projects/spring-data-redis [Accesssed 13 Nov. 2025]

Stalla, A. (8 January 2024) A Guide to Jdbi. Available at: https://www.baeldung.com/jdbi [Accessed 13 Nov. 2025] 
