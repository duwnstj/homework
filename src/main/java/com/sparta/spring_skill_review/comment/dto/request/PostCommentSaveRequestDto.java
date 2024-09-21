package com.sparta.spring_skill_review.comment.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentSaveRequestDto {

    private String writerName;
    private String content;
}
