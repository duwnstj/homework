package com.sparta.spring_skill_review.domain.todo.entity;

import com.sparta.spring_skill_review.domain.comment.entity.Comment;
import com.sparta.spring_skill_review.domain.common.entity.TimeStamped;
import com.sparta.spring_skill_review.domain.manager.entity.Manager;
import com.sparta.spring_skill_review.domain.user.entity.User;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    private String title;
    private String content;

    @OneToMany(mappedBy = "todo",cascade = CascadeType.REMOVE)
    private List<Manager> managerList = new ArrayList<>();

    @OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE)
    private List<Comment> commentList = new ArrayList<>();

    public Todo(User user, String title, String content) {

        this.user = user;
        this.title = title;
        this.content = content;

    }


    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
