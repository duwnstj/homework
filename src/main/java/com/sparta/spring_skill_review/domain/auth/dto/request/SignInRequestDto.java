package com.sparta.spring_skill_review.domain.auth.dto.request;

import lombok.Getter;

@Getter
public class SignInRequestDto {
    private String email;
    private String password;
}
