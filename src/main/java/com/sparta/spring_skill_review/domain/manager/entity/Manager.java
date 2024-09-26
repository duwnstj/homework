package com.sparta.spring_skill_review.domain.manager.entity;

import com.sparta.spring_skill_review.domain.todo.entity.Todo;
import com.sparta.spring_skill_review.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "Manager")
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id",nullable = false)
    private Todo todo;

    public Manager(User managerUser, Todo todo) {
        this.user = managerUser;
        this.todo =todo;
    }
}
