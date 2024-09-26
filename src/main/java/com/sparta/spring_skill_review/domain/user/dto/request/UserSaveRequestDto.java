package com.sparta.spring_skill_review.domain.user.dto.request;

import lombok.Getter;

@Getter
public class UserSaveRequestDto {

    private String userName;
    private String email;
    private String password;
}
