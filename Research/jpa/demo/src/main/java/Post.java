import jakarta.persistence.*;

/* 
 * @Entity makes this class a JPA entity, meaning it will be mapped to a database table.
 * 
 * @Table (optional) gives additional information about how the table should be mapped.
 * In this case, it specifies the table name as "posts".
 * If @Table is not provided, JPA will use the class name as the default table name.
 */
@Entity
@Table(name = "posts")
public class Post {

    /**
     * @Id defines the primary key of the entity.
     * @GeneratedValue specifies how the primary key should be generated, here it uses the database’s auto-increment feature.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String content;

    /*
     * @ManyToOne defines a many-to-one relationship between posts and users, fetch = FetchType.LAZY means the 
     * associated user will only be fetched from the database when explicitly accessed.
     *
     * @JoinColumn(name = "user_id") specifies the foreign key column name in the posts table.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    /* No-arguments constructor (required) */
    public Post() {}

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Long getId() { return id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }

    public void setContent(String content) { this.content = content; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Post{id=%d, title='%s', content='%s'}".formatted(id, title, content);
    }
}
