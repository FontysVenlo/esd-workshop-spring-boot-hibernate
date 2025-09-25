## General information
Hibernate ORM is an object-relational mapping (ORM) library for Java. It helps map between Java objects and relational database tables, making it easier to work with databases in an object-oriented way. 

It supports operations like querying, saving, updating, and deleting entities in the database, while keeping your domain model in Java.

JPA Compatibility:
- Hibernate implements the Jakarta Persistence (JPA) specification. 
- You can use Hibernate in environments that expect JPA (Java SE, Java EE, or frameworks like Springboot). 

Idiomatic Java:
- Persistent classes can be plain java classes, no need to implement interfaces.
- Mappings can be defined via (JPA) annotations or XML. 

Performance & Caching / Tuning:
- Supports two-level caching (first-level = session, second-level = shared) for better performance. 
- Fetching strategies (lazy vs eager), locking strategies (optimistic, pessimistic), and other internals are configurable. 
- Much of the SQL generation is done at initialization time rather than runtime, reducing runtime overhead. 

Scalability & Robustness: 
- Designed for high concurrency and usage in clustered environments. 
- Used in production in many enterprise systems across industries. 

Powerful Query Capabilities:
- Hibernate introduces HQL (Hibernate Query Language), an object-oriented, SQL-inspired query language, with support for many features of ANSI SQL. 
- Type-checking and validation of HQL queries can happen at compile time (using metadata) rather than only at runtime. 
- If needed, you can also drop down and use native SQL queries. 

Broad Database Support / Dialects:
- Hibernate is tested daily on many major RDBMS systems: PostgreSQL, MySQL, Oracle, SQL Server, MariaDB, DB2, H2, etc. 
- It also provides a “dialects” module to support older or less common databases (e.g. Informix, Teradata) and incubating support for SQLite.

Source:
https://hibernate.org/orm/


### Pros 
- Less boilerplate: You write less SQL, Hibernate handles CRUD.
- Database independence: Switching DBs is easier.
- Caching: Hibernate can cache queries and entities to speed up performance.
- Relationships: Easy mapping of @OneToMany, @ManyToOne etc.

### Cons 
- Can be complex to configure.
- Performance overhead if misused.
- You lose some fine-grained control compared to raw SQL (you can still define raw SQL though).


## How to use it
Querying:
- stateless/stateful
- transaction/locks

Migrating

Entities/Annotations



## Extra

### Topic not (yet) covered
- Hibernate search
- Hibernate validator

### Some extra links
- [7 features youre not using but should be](https://medium.com/%40thecodealchemistX/top-7-hibernate-features-youre-not-using-but-should-be-7fd6e4fe983f)
- [Performance tuning](https://medium.com/%40noel.benji/hibernate-performance-tuning-secrets-to-lightning-fast-database-access-4456124c80b4)
- [Performance tuning](https://www.javacodegeeks.com/2025/09/advanced-hibernate-performance-tuning-caching-fetch-strategies-and-batch-processing.html)
- [Dirty checking](https://medium.com/jpa-java-persistence-api-guide/dirty-checking-magic-in-hibernate-how-it-works-and-why-its-important-3cdb422dc4d4)
- [Tuning, caching, fetching, batch processing](https://www.javacodegeeks.com/2025/09/advanced-hibernate-performance-tuning-caching-fetch-strategies-and-batch-processing.html)
