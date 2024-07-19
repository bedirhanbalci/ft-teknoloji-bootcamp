package com.patika.bloghubservice.controller;

import com.patika.bloghubservice.model.Blog;
import com.patika.bloghubservice.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/users/{email}")
    public Blog createBlog(@RequestBody Blog blog, @PathVariable String email) {
        return blogService.createBlog(email, blog);
    }

    @GetMapping
    public List<Blog> getAllBlogs() {
        return blogService.getAll();
    }

    @GetMapping("/{title}")
    public Blog getBlogByEmail(@PathVariable String title) {
        return blogService.getBlogByTitle(title);
    }

    @PutMapping("/{title}/users/{email}")
    public void addComment(@PathVariable String title, @PathVariable String email, @RequestBody String comment) {
        blogService.addComment(title, email, comment);
    }


    @PutMapping("/{title}/users/{email}/like-count")
    public void likeBlog(@PathVariable String title, @PathVariable String email) {
        // bir kullanıcı maksimum 50 kere beğenebilir
        blogService.likeBlog(title, email);
    }

    @GetMapping("/{title}/like-count")
    public Long getLikeCountByTitle(@PathVariable String title) {
        return blogService.getLikeCountByTitle(title);
    }

    // comment'leri getiren end-point
    // kullanıcı sadece kendi blog'larını gören end-point
    // resim yükleme

}
