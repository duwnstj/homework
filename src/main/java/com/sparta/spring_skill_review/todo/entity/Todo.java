package com.sparta.spring_skill_review.todo.entity;

import com.sparta.spring_skill_review.comment.entity.Comment;
import com.sparta.spring_skill_review.common.TimeStamped;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    public Todo(String writerName, String title, String content) {
        this.writerName = writerName;
        this.title = title;
        this.content = content;

    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
