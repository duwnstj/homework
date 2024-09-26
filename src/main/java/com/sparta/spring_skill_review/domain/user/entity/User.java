package com.sparta.spring_skill_review.domain.user.entity;

import com.sparta.spring_skill_review.domain.common.dto.AuthUser;
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
    private Long id;
    private String email;
    private String userName;
    private String password;

    public User(String email,String userName,String password) {
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    public User(Long id, String email) {
        this.id =id;
        this.email =email;
    }


    public static User fromAuthUser(AuthUser authUser) {
        return new User(authUser.getId(), authUser.getEmail());
    }


}
