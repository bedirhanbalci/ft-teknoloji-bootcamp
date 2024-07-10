import model.Blog;
import model.BlogComment;
import model.BlogTag;
import model.User;
import model.enums.BlogStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        List<User> userList = new ArrayList<>();

        User user = new User("bedir@gmail.com", "admin123");
        userList.add(user);

        User user1 = new User("cem@gmail.com", "123456");
        userList.add(user1);

        List<Blog> blogList = new ArrayList<>();

        Blog blog = new Blog("Instancio: A New Way to Create Test Data",
                "When writing unit tests, we often use mock data because our goal is to verify that a specific method performs its task as expected.",
                user);

        blog.getBlogCommentList().add(new BlogComment(user, "çok kötü olmuş"));

        blogList.add(blog);

        user.setBlogList(List.of(blog));

        List<Blog> userBlogList = user.getBlogList();

        List<Blog> userDraftBlogList = new ArrayList<>();
        List<Blog> userPublishedBlogList = new ArrayList<>();

        for (Blog userBlog : userBlogList) {
            if (BlogStatus.DRAFT.equals(userBlog.getBlogStatus())) {
                userDraftBlogList.add(userBlog);
            } else if (BlogStatus.PUBLISHED.equals(userBlog.getBlogStatus())) {
                userPublishedBlogList.add(userBlog);
            }
        }

        //  Stream Kullanımı

        List<Blog> userDraftList = userBlogList.stream()
                .filter(it -> BlogStatus.DRAFT.equals(it.getBlogStatus()))
                .toList();

        List<Blog> userPublishedList = userBlogList.stream()
                .filter(it -> BlogStatus.PUBLISHED.equals(it.getBlogStatus()))
                .toList();


        user.getFollowedTagList().add(new BlogTag("Space"));
        user.getFollowedTagList().add(new BlogTag("Programming"));

        List<BlogTag> followedTagList = user.getFollowedTagList();

        // TODO bütün bloglar içerisinde kullanıcının takip ettiği blogları bul

        Optional<Blog> instancioBlog = blogList.stream()
                .filter(blog1 -> blog1.getTitle().equals("Instancio: A New Way to Create Test Data"))
                .findFirst();

        Blog blog1 = instancioBlog.orElseThrow(() -> new RuntimeException("bu isimde bir blog bulunamadı"));

        if (instancioBlog.isEmpty()) {
            System.out.println("bu isimde bir blog bulunamadı");
            throw new RuntimeException("bu isimde bir blog bulunamadı");
        }

        Optional<Blog> willBeDraftBlog = user.getBlogList()
                .stream()
                .filter(blog2 -> blog2.getTitle().equals("Instancio: A New Way to Create Test Data"))
                .findFirst();

        if (willBeDraftBlog.isEmpty()) {
            System.out.println("bu isimde bir blog bulunamadı");
            throw new RuntimeException("bu isimde bir blog bulunamadı");
        }

        if (BlogStatus.PUBLISHED.equals(willBeDraftBlog.get().getBlogStatus())) {
            System.out.println("published olan blog delete edilemez. önce draft yapın.");
            throw new RuntimeException("published olan blog delete edilemez. önce draft yapın.");
        }

        willBeDraftBlog.get().setBlogStatus(BlogStatus.DRAFT);

    }
}
