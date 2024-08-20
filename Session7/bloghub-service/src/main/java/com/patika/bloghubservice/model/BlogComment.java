package com.patika.bloghubservice.model;

import com.patika.bloghubservice.constant.BlogCommentEntityConstants;
import com.patika.bloghubservice.model.enums.BlogCommentType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "blog_comments")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = BlogCommentEntityConstants.ID)
    private Long id;

    @Column(name = BlogCommentEntityConstants.USER_ID)
    private Long userId;

    @Column(name = BlogCommentEntityConstants.COMMENT)
    private String comment;

    @Column(name = BlogCommentEntityConstants.CREATED_DATE)
    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    @Column(name = BlogCommentEntityConstants.BLOG_COMMENT_TYPE)
    private BlogCommentType blogCommentType;


}
