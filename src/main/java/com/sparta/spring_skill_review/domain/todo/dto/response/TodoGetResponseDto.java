package com.sparta.spring_skill_review.domain.todo.dto.response;

import com.sparta.spring_skill_review.domain.manager.dto.response.ManagerResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
public class TodoGetResponseDto {
    private final Long id ;
    private final String writerName;
    private final String title;
    private final String content;
    private final String createAt;
    private final String modifiedAt;
    private final List<ManagerResponseDto> managerList;

    public TodoGetResponseDto(Long id , String writerName, String title, String content, LocalDateTime createAt, LocalDateTime modifiedAt, List<ManagerResponseDto> managerDtoList){
        this.id = id;
        this.writerName = writerName;
        this.title = title;
        this.content = content;
        this.createAt = createAt.format(DateTimeFormatter.ofPattern("yyyy년 M월 dd일"));
        this.modifiedAt = modifiedAt.format(DateTimeFormatter.ofPattern("yyyy년 M월 dd일"));
        this.managerList =managerDtoList;
    }
}


