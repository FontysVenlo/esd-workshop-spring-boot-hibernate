import jakarta.persistence.*;
import java.util.List;

public class PostDao {

    /** 
     * Create an EntityManagerFactory based on the persistence unit name specified in resources/META-INF/persistence.xml.
     */
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");

    /**
     * The persist method must be executed within a transaction otherwise, JPA will throw a TransactionRequiredException.
     */
    public void create(Post post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();               
            em.persist(post);        
            tx.commit();              
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback(); 
            throw e;
        } finally {
            em.close();               
        }
    }

    /**
     * This query uses JPQL (Java Persistence Query Language), which operates 
     * on entity objects and their fields.
     */
    public List<Post> findByUserId(Long userId) {
        EntityManager em = emf.createEntityManager();
        List<Post> posts = em.createQuery(
                "SELECT p FROM Post p WHERE p.user.id = :userId", Post.class
            )
            .setParameter("userId", userId)
            .getResultList();
        em.close();
        return posts;
    }

    /**
     * Closes the EntityManagerFactory when the DAO is no longer needed.
     * 
     * Should be called when the application shuts down to release all database and JPA resources.
     */
    public void close() { 
        emf.close(); 
    }
}
