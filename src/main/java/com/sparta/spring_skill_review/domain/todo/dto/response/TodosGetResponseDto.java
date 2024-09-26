package com.sparta.spring_skill_review.domain.todo.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class TodosGetResponseDto {

    private final String todoTitle;
    private final String todoContent;
    private final Integer commentCount;
    private final String createAt;
    private final String modifiedAt;
    private final String todoWriter;


    public TodosGetResponseDto(String todoTitle, String todoContent, Integer commentCount, LocalDateTime createAt, LocalDateTime modifiedAt, String todoWriter) {
        this.todoTitle = todoTitle;
        this.todoContent = todoContent;
        this.commentCount =commentCount;
        this.createAt =createAt.format(DateTimeFormatter.ofPattern("yyyy년-MM월-dd일"));
        this.modifiedAt =modifiedAt.format(DateTimeFormatter.ofPattern("yyyy년-MM월-dd일"));
        this.todoWriter =todoWriter;
    }


}
