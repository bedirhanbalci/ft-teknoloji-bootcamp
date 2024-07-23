package com.patika.bloghubservice.dto.request;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequest {

    private String name;

    private String email;

    private String password;


}
