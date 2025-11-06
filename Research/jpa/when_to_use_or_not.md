# When and When Not to Use JPA

## When/Why to Use (Pros)

### 1. Automatic Object Mapping
JPA lets you work with Java objects instead of writing SQL directly, it automatically maps classes and relationships to the database.

### 2. Schema Evolves with the Application
It provides automatic schema generation and simplifies migrations when entities change (not recommended in production environments but it is tweakable).

### 3. Vendor Independence
 JPA is an abstraction over SQL dialects and JDBC, which makes it easier to switch between relational databases vendors with minimal changes.

### 4. Transparent Caching and Lifecycle Management
JPA provides first-level caching, lazy loading, and automatic dirty checking as part of its core lifecycle management.

Many JPA implementations (such as Hibernate) also offer optional second-level caching for improved performance.

---

## When/Why NOT to Use (Cons)

### 1. Non-relational data or Non-table-like structure
JPA is designed for relational databases. It’s not a good fit for NoSQL systems or applications where data isn’t normalized.

### 2. Startup Time and Overhead
The ORM layer introduces initialization overhead, reflection usage, and proxy generation. For lightweight microservices or low-latency applications, low-level alternatives might be a better fit.

### 3. Efficiency
In performance-critical scenarios or when using complex and highly optimized SQL queries, JPA’s abstraction can become a limitation, manual SQL provides better control and efficiency

### 4. Limited benefit outside Spring (Boot)
The Java Persistence API complements Spring (Boot) very well, even though it is not limited to the Spring eco-system outside of it, it might become more difficult to use and other ORM's might be better suited for the task. 

---

## References

- [Why and when use JPA](https://vladmihalcea.com/why-and-when-use-jpa/)  
- [Advantages of not using Spring Data and Hibernate with relational data](https://itnext.io/advantages-of-not-using-spring-data-and-hibernate-with-relational-data-8a509faf0c48)  
- [What is Spring Data JPA and why should you use it](https://thorben-janssen.com/what-is-spring-data-jpa-and-why-should-you-use-it/)  
- [When to use JPA specification over native query or JPQL in Java Spring Boot](https://ezehash.hashnode.dev/when-to-use-jpa-specification-over-native-query-or-jpql-in-java-spring-boot)
