package com.sparta.spring_skill_review.domain.manager.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ManagerResponseDto {
    private final Long managerUserId;
    private final String managerUserName;
    private final String managerEmail;




}
