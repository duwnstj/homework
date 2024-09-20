package com.sparta.spring_skill_review.todo.entity;

import com.sparta.spring_skill_review.common.TimeStamped;
import com.sparta.spring_skill_review.todo.dto.request.TodoSaveRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Todo")

public class Todo extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String writerName;
    private String title;
    private String content;

    public Todo(String writerName, String title , String content){
        this.writerName = writerName;
        this.title = title;
        this.content = content;

    }


    public void update(String title , String content) {
        this.title = title;
        this.content = content;
    }
}
