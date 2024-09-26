package com.sparta.spring_skill_review.domain.comment.entity;

import com.sparta.spring_skill_review.domain.common.entity.TimeStamped;
import com.sparta.spring_skill_review.domain.todo.entity.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment  extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String writerName;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "todoId")
    private Todo todo;

    public Comment(String content, String writerName, Todo todo) {

        this.content =content;
        this.writerName = writerName;
        this.todo =todo;
    }

    public void update(String commentContent) {

        this.content = commentContent;
    }
}
