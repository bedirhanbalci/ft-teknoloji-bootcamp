package com.patika.bloghubuserservice.model;

import com.patika.bloghubuserservice.constant.UserEntityConstants;
import com.patika.bloghubuserservice.model.enums.StatusType;
import com.patika.bloghubuserservice.model.enums.UserType;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = UserEntityConstants.ID)
    private Long id;

    @Column(name = UserEntityConstants.EMAIL)
    private String email;

    @Column(name = UserEntityConstants.PASSWORD)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = UserEntityConstants.USER_TYPE)
    private UserType userType;

    @Column(name = UserEntityConstants.BIO)
    private String bio;

    @Enumerated(EnumType.STRING)
    @Column(name = UserEntityConstants.STATUS_TYPE)
    private StatusType statusType;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

//    private Set<SocialMedia> socialMediaList;

//    private List<BlogTag> followedTagList = new ArrayList<>();


}
