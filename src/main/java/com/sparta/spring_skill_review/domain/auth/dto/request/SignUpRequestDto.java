package com.sparta.spring_skill_review.domain.auth.dto.request;

import lombok.Getter;

@Getter
public class SignUpRequestDto {
    private String email;
    private String userName;
    private String password;
}
