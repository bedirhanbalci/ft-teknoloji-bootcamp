package com.patika.bloghubservice.dto.response;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BlogSearchResponse implements Serializable {

    private List<BlogResponse> blogResponses;

    private int totalPage;

    private long totalElement;

}
