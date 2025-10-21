# How to use


## Basic use
- Entities: using JPA annotations create the dataclass, 

```java
import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    // Constructors, getters, and setters
}

```
- EntityManager: use the entity manager to manage the transaction and persist the data
```java
EntityManagerFactory emf = Persistence.createEntityManagerFactory("my-persistence-unit");

EntityManager em = emf.createEntityManager();

try {

    em.getTransaction().begin();

    Employee emp = new Employee("John Doe", "john.doe@example.com");

    em.persist(emp);

    em.getTransaction().commit();

} catch (Exception e) {
    if (em.getTransaction().isActive()) {
        em.getTransaction().rollback();
    }
    e.printStackTrace();
} finally {
    em.close();
    emf.close();
}
```

## Sources:
- https://www.infoworld.com/article/2259807/what-is-jpa-introduction-to-the-java-persistence-api.html
- https://www.geeksforgeeks.org/java/jpa-introduction/

----

References
[REFERENCE 1](www..nl)