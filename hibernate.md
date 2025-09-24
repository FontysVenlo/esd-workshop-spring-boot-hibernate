### General information
Hibernate implements the JPA Interface by default JPA used Hibernate but you could swap it <br>
Simplifies the database connection, you don't need to write the (prepared) query yourself, just give it the object(s) and it will store it for you, just call a get-method and you will get them (concept of ORM (object relational mapping) <br>

### Pros 
- Less boilerplate: You write less SQL, Hibernate handles CRUD.
- Database independence: Switching DBs is easier.
- Caching: Hibernate can cache queries and entities to speed up performance.
- Relationships: Easy mapping of @OneToMany, @ManyToOne etc.

### Cons 
- Can be complex to configure.
- Performance overhead if misused.
- You lose some fine-grained control compared to raw SQL (you can still define raw SQL though).

### Some links
- [7 features youre not using but should be](https://medium.com/%40thecodealchemistX/top-7-hibernate-features-youre-not-using-but-should-be-7fd6e4fe983f)
- [Performance tuning](https://medium.com/%40noel.benji/hibernate-performance-tuning-secrets-to-lightning-fast-database-access-4456124c80b4)
- [Performance tuning](https://www.javacodegeeks.com/2025/09/advanced-hibernate-performance-tuning-caching-fetch-strategies-and-batch-processing.html)
- [Dirty checking](https://medium.com/jpa-java-persistence-api-guide/dirty-checking-magic-in-hibernate-how-it-works-and-why-its-important-3cdb422dc4d4)
- [Tuning, caching, fetching, batch processing](https://www.javacodegeeks.com/2025/09/advanced-hibernate-performance-tuning-caching-fetch-strategies-and-batch-processing.html)
