package com.patika.bloghubindexservice.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Blog {

    private Long id;

    private String title;

    private String text;

    private LocalDateTime createdDate;

    private Long likeCount;

}
