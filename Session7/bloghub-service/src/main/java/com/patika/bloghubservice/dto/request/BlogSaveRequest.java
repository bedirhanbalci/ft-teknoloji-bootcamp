package com.patika.bloghubservice.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogSaveRequest {

    private String title;

    private String text;

    private String email;

}
