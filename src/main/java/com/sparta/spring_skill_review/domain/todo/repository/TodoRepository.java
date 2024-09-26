package com.sparta.spring_skill_review.domain.todo.repository;

import com.sparta.spring_skill_review.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo , Long> {


    Page<Todo> findAllByOrderByModifiedAtDesc(Pageable pageable);
}
