package com.patika.bloghubservice.controller;

import com.patika.bloghubservice.dto.request.BlogSaveRequest;
import com.patika.bloghubservice.dto.response.BlogResponse;
import com.patika.bloghubservice.dto.response.GenericResponse;
import com.patika.bloghubservice.model.Blog;
import com.patika.bloghubservice.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blogs")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/users/{email}")
    public GenericResponse<BlogResponse> createBlog(@RequestBody BlogSaveRequest request, @PathVariable String email) {
        return GenericResponse.success(blogService.createBlog(email, request), HttpStatus.CREATED);
    }

    @GetMapping
    public GenericResponse<List<BlogResponse>> getAllBlogs() {
        return GenericResponse.success(blogService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{title}")
    public GenericResponse<Blog> getBlogByEmail(@PathVariable String title) {
        return GenericResponse.success(blogService.getBlogByTitle(title), HttpStatus.OK);
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
