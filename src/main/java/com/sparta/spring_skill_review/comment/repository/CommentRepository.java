package com.sparta.spring_skill_review.comment.repository;

import com.sparta.spring_skill_review.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTodoId(Long todoId);
}
