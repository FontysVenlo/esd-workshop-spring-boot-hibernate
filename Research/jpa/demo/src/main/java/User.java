import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* 
 * @Entity makes this class a JPA entity, meaning it will be mapped to a database table.
 * 
 * @Table (optional) gives additional information about how the table should be mapped.
 * In this case, it specifies the table name as "users".
 * If @Table is not provided, JPA will use the class name as the default table name.
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * @Id defines the primary key of the entity.
     * @GeneratedValue specifies how the primary key should be generated, here it uses the database’s auto-increment feature.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    /* 
     * Defines a one-to-many relationship between User and Post.
     * 
     * @OneToMany one User can have many Posts.
     * - The "mappedBy" attribute tells JPA that the relationship is bidirectional and that the "user" field in the Post class owns the relationship.
     *   This prevents JPA from creating an extra join table.
     * - CascadeType.ALL: any persistence operation done to the user will be cascaded to all of its Posts.
     * - orphanRemoval: if a Post is removed from the "posts" list (and is no longer reference to a user), it will be deleted from the database as well.
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Post> posts = new ArrayList<>();

    /* No-arguments constructor (required) */
    public User() {}

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public List<Post> getPosts() { return posts; }

    public void addPost(Post post) {
        posts.add(post);
        post.setUser(this);
    }

    public void removePost(Post post) {
        posts.remove(post);
        post.setUser(null);
    }

    @Override
    public String toString() {
        return "User{id=%d, name='%s', email='%s', posts=%d}".formatted(
                id, name, email, posts.size()
        );
    }
}
