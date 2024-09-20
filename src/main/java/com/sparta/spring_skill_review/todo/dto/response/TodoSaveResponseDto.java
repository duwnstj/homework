package com.sparta.spring_skill_review.todo.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public class TodoSaveResponseDto {
    private final Long id ;
    private final String writerName;
    private final String title;
    private final String content;
}
