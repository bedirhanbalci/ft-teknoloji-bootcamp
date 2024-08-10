package com.patika.bloghubservice.client.user.service.dto.response;

import com.patika.bloghubservice.client.user.service.dto.response.enums.UserType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long userId;

    private String email;

    private UserType userType;

    private String bio;

//    private Set<SocialMedia> socialMediaList;

}
