package com.sparta.spring_skill_review.domain.common.dto;

import com.sparta.spring_skill_review.domain.user.enums.UserRole;
import lombok.Getter;

@Getter
public class AuthUser {

    private final Long id;
    private final String email;
    private final String userName;

    public AuthUser(Long id, String email, String userName) {
        this.id = id;
        this.email = email;
        this.userName = userName;

    }
}
