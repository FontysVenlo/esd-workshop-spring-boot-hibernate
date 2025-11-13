import jakarta.persistence.*;
import java.util.List;

public class UserDao {

    /** 
     * Create an EntityManagerFactory based on the persistence unit name specified in resources/META-INF/persistence.xml.
     */
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");

    /**
     * The persist method must be executed within a transaction otherwise, JPA will throw a TransactionRequiredException.
     */
    public void create(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();           
            em.persist(user);     
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
    public User find(Long id) {
        EntityManager em = emf.createEntityManager();
        User user = em.find(User.class, id);
        em.close();
        return user;
    }

    /**
     * This query uses JPQL (Java Persistence Query Language), which operates 
     * on entity objects and their fields.
     */
    public List<User> findAll() {
        EntityManager em = emf.createEntityManager();
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        em.close();
        return users;
    }

    /**
     * The merge method must be executed within a transaction otherwise, JPA will throw a TransactionRequiredException.
     */
    public void update(User user) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(user);
        tx.commit();
        em.close();
    }

    /**
     * The remove method must be executed within a transaction otherwise, JPA will throw a TransactionRequiredException.
     */
    public void delete(Long id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        User user = em.find(User.class, id);
        if (user != null) em.remove(user);
        tx.commit();
        em.close();
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
