package com.sparta.spring_skill_review.comment.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CommentGetResponseDto {

    private final Long id ;
    private final String content;
    private final String writerName;
}
