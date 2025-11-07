public class main {

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        PostDao postDao = new PostDao();

        User user = new User("Alice", "alice@example.com");
        user.addPost(new Post("First Post", "Hello world!"));
        user.addPost(new Post("Second Post", "JPA test post"));

        userDao.create(user);

        User found = userDao.find(user.getId());
        System.out.println(found.getName() + "'s posts:");
        var Posts = postDao.findByUserId(found.getId());

        for(var post : Posts) {
            System.out.println(post);
        }

        userDao.close();
    }

}
