package com.sparta.spring_skill_review.domain.user.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSaveResponseDto {
    private final Long UserId;
    private final String UserName;
    private final String email;
}
