package com.patika.bloghubindexservice.model.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "blog")
public class BlogDocument {

    @Id
    private Long id;

    private String title;

    private String text;

    private LocalDateTime createdDate;

    private Long likeCount;

}
