package com.sparta.spring_skill_review.domain.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoUpdateRequestDto {

    private Long id ;
    private String title;
    private String content;
}
