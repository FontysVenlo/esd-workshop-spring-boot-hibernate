# When and When Not to Use JPA

## When/Why to Use (Pros)

### 1. Automatic Object Mapping
JPA lets you work with Java objects instead of writing SQL directly, it automatically maps classes and relationships to the database (Mihalcea, 2020).

### 2. Schema Evolves with the Application
It provides automatic schema generation and simplifies migrations when entities change (not recommended in production environments but it is tweakable) (Janssen, n.d.).

### 3. Vendor Independence
 JPA is an abstraction over SQL dialects and JDBC, which makes it easier to switch between relational databases vendors with minimal changes (Anigbogu, 2024).

### 4. Transparent Caching and Lifecycle Management
JPA provides first-level caching, lazy loading, and automatic dirty checking as part of its core lifecycle management .
Many JPA implementations (such as Hibernate) also offer optional second-level caching for improved performance (Mihalea, 2020).

---

## When/Why NOT to Use (Cons)

### 1. Non-relational data or Non-table-like structure
JPA is designed for relational databases. It’s not always a good fit for NoSQL systems or applications where data isn’t normalized (Oracle, n.d.).

### 2. Startup Time and Overhead 
The ORM layer introduces initialization overhead, reflection usage, and proxy generation. For lightweight microservices or low-latency applications, low-level alternatives might be a better fit (Anigbogu, 2024).

### 3. Efficiency
In performance-critical scenarios or when using complex and highly optimized SQL queries, JPA’s abstraction can become a limitation, manual SQL provides better control and efficiency (Anigbogu, 2024).

### 4. Limited benefit outside Spring (Boot)
The Java Persistence API complements Spring (Boot) very well, even though it is not limited to the Spring eco-system outside of it, it might become more difficult to use and other ORM's might be better suited for the task (Quora, n.d.). 

---

## References

Anigbogu, C. (3 August 2024) When to Use JPA Specification Over Native Query or JPQL in Java Spring Boot. Available at: https://ezehash.hashnode.dev/when-to-use-jpa-specification-over-native-query-or-jpql-in-java-spring-boot [Accessed 13 Nov. 2025].

Janssen, T. (n.d.) Generate database schema with JPA. Available at: https://thorben-janssen.com/generate-database-schema-jpa/ [Accessed 13 Nov. 2025]

Mihalcea, V. (16 September 2020) Why and when you should use JPA. Available at: https://vladmihalcea.com/why-and-when-use-jpa/ [Accessed 13 Nov. 2025].

Oracle (n.d.) Understanding Non-relational Data Sources. Available at: https://docs.oracle.com/middleware/1221/toplink/concepts/nosql.htm#OTLCG94413 [Accessed 13 Nov. 2025]

Quora (n.d.) Can we use Hibernate without Spring? Available at: https://www.quora.com/Can-we-use-Hibernate-without-Spring [Accessed 13 Nov. 2025]