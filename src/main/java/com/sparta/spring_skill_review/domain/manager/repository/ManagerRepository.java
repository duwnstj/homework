package com.sparta.spring_skill_review.domain.manager.repository;

import com.sparta.spring_skill_review.domain.manager.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query(value = "select m from Manager m JOIN FETCH m.user where m.todo.id = :todoId")
    List<Manager> findByTodoIdWithUser(@Param("todoId") Long todoId);
}
