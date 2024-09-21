package com.sparta.spring_skill_review.comment.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostCommentSaveResponseDto {
    private final Long todoId;
    private final String content;
    private final String writerName;
}
