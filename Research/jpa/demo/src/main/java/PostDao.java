import jakarta.persistence.*;
import java.util.List;

public class PostDao {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("examplePU");

    public void create(Post post) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(post);
        tx.commit();
        em.close();
    }

    public List<Post> findByUserId(Long userId) {
        EntityManager em = emf.createEntityManager();
        List<Post> posts = em.createQuery(
                        "SELECT p FROM Post p WHERE p.user.id = :userId", Post.class
                ).setParameter("userId", userId)
                .getResultList();
        em.close();
        return posts;
    }

    public void close() { emf.close(); }
}
