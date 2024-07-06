import model.Blog;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();

        User user = new User("bedir@gmail.com", "admin123");
        userList.add(user);

        User user1 = new User("cem@gmail.com", "123456");
        userList.add(user1);

        List<Blog> blogList = new ArrayList<>();

        Blog blog = new Blog("asdsadasdas", "asdhklasjhdlkashkldasasdasdasadsadsdasdasasdas",
                user);

        blogList.add(blog);

    }
}
