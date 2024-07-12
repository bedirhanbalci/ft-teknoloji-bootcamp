import model.Blog;
import model.User;
import model.enums.BlogStatus;
import model.enums.StatusType;
import repository.BlogRepository;
import repository.UserRepository;
import service.BlogService;
import service.UserService;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        UserService userService = new UserService(new UserRepository());

        BlogService blogService = new BlogService(new BlogRepository(), userService);


        userService.saveUser("bedir@gmail.com", "password");
        userService.saveUser("cem@gmail.com", "123456");
        userService.saveUser("aziz@gmail.com", "123456");

        userService.changeStatus("bedir@gmail.com", StatusType.APPROVED);
        userService.changeStatus("cem@gmail.com", StatusType.APPROVED);
        userService.changeStatus("aziz@gmail.com", StatusType.APPROVED);

        userService.changeStatus(List.of("bedir@gmail.com", "cem@gmail.com"), StatusType.APPROVED);

        userService.getAllUsers().forEach(System.out::println);

        userService.getAllUsers()
                .stream()
                .peek(System.out::println)
                .filter(user -> user.getEmail().equals("bedir@gmail.com"))
                .toList();

        List<String> emailList = userService.getAllUsers()
                .stream()
                .map(User::getEmail)
                .toList();

        List<Blog> allUsersBlogList = userService.getAllUsers()
                .stream()
                .flatMap(user -> user.getBlogList().stream())
                .toList();

        Map<String, User> emailUserMap = userService.getAllUsersMap();

        User bedirUser = emailUserMap.get("bedir@gmail.com");


        User foundUser = userService.getUserByEmail("bedir@gmail.com");


        blogService.createBlog("baslik", "icerik", "bedir@gmail.com");

        Blog foundBlog = blogService.getBlogByTitle("baslik");
        blogService.addComment("baslik", "cok kotu olmus", foundUser);


        // -- for ile yapımı

        /*
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
         */


        /*
        // ödev - kullanıcının takip ettiği tag'lere göre blog'lar gelmeli

        user.getFollowedTagList().add(new BlogTag("Space"));
        user.getFollowedTagList().add(new BlogTag("Programming"));

        List<BlogTag> followedTagList = user.getFollowedTagList();

        // TODO bütün bloglar içerisinde kullanıcının takip ettiği blogları bul
        */


        /*
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
        */

        blogService.changeBlogStatus(BlogStatus.DELETED, "baslik");

    }
}
