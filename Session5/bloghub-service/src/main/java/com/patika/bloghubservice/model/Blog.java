package com.patika.bloghubservice.model;

import com.patika.bloghubservice.model.enums.BlogStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Blog {

    private String title;

    private String text;

    private LocalDateTime createdDate;

    private User user;

    private BlogStatus blogStatus;

    private Long likeCount;

    private List<BlogComment> blogCommentList = new ArrayList<>();

    public Blog(String title, String text, User user) {
        this.title = title;
        this.text = text;
        this.user = user;
        this.createdDate = LocalDateTime.now();
        this.blogStatus = BlogStatus.DRAFT;
        this.likeCount = 0L;
    }

}
