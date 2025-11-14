# How to use

This file shows the (possible) structure of a JPA implementation, the explanations of how JPA is used are present in comments in the files below. <br>
However, there are many more possible functions and annotations available, many of these are available in the sources at the bottom of this file. 

- [resources\META-INF\persistence.xml](demo/src/main/resources/META-INF/persistence.xml): Defines which classes JPA tracks, database connection and provider

- Entity classes [Post](demo/src/main/java/Post.java) & [User](demo/src/main/java/User.java): Defines the fields, their constraints and relations

- Data access objects or repositories [PostDao](demo/src/main/java/PostDao.java) & [UserDao](demo/src/main/java/UserDao.java): Encapsulate database access using JPA


Sources used to create and comment the JPA demo project:
- https://www.infoworld.com/article/2259807/what-is-jpa-introduction-to-the-java-persistence-api.html
- https://www.geeksforgeeks.org/java/jpa-introduction/

- https://docs.spring.io/spring-data/jpa/reference/jpa.html