package com.patika.bloghubservice.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogSearchRequest extends BaseSearchRequest {

    private String title;

    private long likeCount;

}
