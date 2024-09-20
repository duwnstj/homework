package com.sparta.spring_skill_review.todo.repository;

import com.sparta.spring_skill_review.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo , Long> {

}
