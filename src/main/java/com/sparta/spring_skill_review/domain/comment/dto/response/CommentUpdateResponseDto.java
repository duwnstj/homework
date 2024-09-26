package com.sparta.spring_skill_review.domain.comment.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentUpdateResponseDto {
    private final Long commentId;
    private final String commentWriter;
    private final String commentContent;
}
