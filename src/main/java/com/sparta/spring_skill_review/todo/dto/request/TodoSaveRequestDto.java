package com.sparta.spring_skill_review.todo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoSaveRequestDto {

    private String writerName;
    private String title;
    private String content;
}
