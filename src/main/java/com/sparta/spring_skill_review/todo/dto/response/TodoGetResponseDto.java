package com.sparta.spring_skill_review.todo.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class TodoGetResponseDto {
    private final Long id ;
    private final String writerName;
    private final String title;
    private final String content;
    private final String createAt;
    private final String modifiedAt;

    public TodoGetResponseDto(Long id , String writerName, String title,String content,LocalDateTime createAt,LocalDateTime modifiedAt){
        this.id = id;
        this.writerName = writerName;
        this.title = title;
        this.content = content;
        this.createAt = createAt.format(DateTimeFormatter.ofPattern("yyyy년 M월 dd일"));
        this.modifiedAt = modifiedAt.format(DateTimeFormatter.ofPattern("yyyy년 M월 dd일"));
    }
}


