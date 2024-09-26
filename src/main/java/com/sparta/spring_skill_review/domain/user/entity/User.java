package com.sparta.spring_skill_review.domain.user.entity;

import com.sparta.spring_skill_review.domain.common.entity.TimeStamped;
import com.sparta.spring_skill_review.domain.todo.entity.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User extends TimeStamped {

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    List<Todo> TodoList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String email;
    private String userName;
    private String password;

    public User(String email,String userName,String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }


}
