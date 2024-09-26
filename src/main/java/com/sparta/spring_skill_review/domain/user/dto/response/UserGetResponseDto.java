package com.sparta.spring_skill_review.domain.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserGetResponseDto {
    private final Long userId;
    private final String userName;
    private final String email;
}
