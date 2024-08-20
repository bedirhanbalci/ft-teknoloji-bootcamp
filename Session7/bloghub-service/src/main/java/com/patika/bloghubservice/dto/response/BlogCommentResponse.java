package com.patika.bloghubservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class BlogCommentResponse implements Serializable {

    private String comment;

}
