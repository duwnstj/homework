package com.sparta.spring_skill_review.domain.auth.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpResponseDto {
    private final String bearerToken;
}
