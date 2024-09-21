package com.sparta.spring_skill_review.comment.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class CommentsGetResponseDto {
    private final Long commentId;
    private final String commentWriter;
    private final String comment;

}
