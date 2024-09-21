package com.sparta.spring_skill_review.comment.service;

import com.sparta.spring_skill_review.comment.dto.request.CommentUpdateRequestDto;
import com.sparta.spring_skill_review.comment.dto.request.PostCommentSaveRequestDto;
import com.sparta.spring_skill_review.comment.dto.response.CommentGetResponseDto;
import com.sparta.spring_skill_review.comment.dto.response.CommentUpdateResponseDto;
import com.sparta.spring_skill_review.comment.dto.response.CommentsGetResponseDto;
import com.sparta.spring_skill_review.comment.dto.response.PostCommentSaveResponseDto;
import com.sparta.spring_skill_review.comment.entity.Comment;
import com.sparta.spring_skill_review.comment.repository.CommentRepository;
import com.sparta.spring_skill_review.todo.entity.Todo;
import com.sparta.spring_skill_review.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {

    private final CommentRepository commentRepository;
    private final TodoRepository todoRepository;

    // 댓글 저장
    @Transactional
    public PostCommentSaveResponseDto saveComment(PostCommentSaveRequestDto requestDto, Long todoId) {

        Todo todo = findTodo(todoId);

        Comment comment = new Comment(
                requestDto.getContent(),
                requestDto.getWriterName(),
                todo
        );
        Comment saveComment = commentRepository.save(comment);

        return new PostCommentSaveResponseDto(
                saveComment.getTodo().getId(),
                saveComment.getContent(),
                saveComment.getWriterName()
        );

    }

    // 댓글 단건 조회
    public CommentGetResponseDto getComment(Long commentId) {

        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NullPointerException("댓글을 찾을 수 없습니다"));

        return new CommentGetResponseDto(
                comment.getId(),
                comment.getContent(),
                comment.getWriterName()
        );
    }

    //댓글 전체 조회
    public List<CommentsGetResponseDto> getComments(Long todoId) {

        List<Comment> getComments = commentRepository.findByTodoId(todoId);

        List<CommentsGetResponseDto> dtoList = new ArrayList<>();

        for (Comment comments : getComments) {
            CommentsGetResponseDto dto = new CommentsGetResponseDto(
                    comments.getId(),
                    comments.getWriterName(),
                    comments.getContent()
            );
            dtoList.add(dto);
        }
        return dtoList;

    }

    // 댓글 수정
    @Transactional
    public CommentUpdateResponseDto updateComment(Long commentId, CommentUpdateRequestDto requestDto) {
        Comment comment = findComment(commentId);

        comment.update(
                requestDto.getCommentContent()
        );
        return new CommentUpdateResponseDto(
                comment.getId(),
                comment.getWriterName(),
                comment.getContent()
        );
    }

    //댓글 삭제
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    //일정 찾는 메서드
    public Todo findTodo(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("일정을 찾을 수 없습니다."));
    }

    // 댓글 찾는 메서드
    public Comment findComment(Long commentId) {
        return commentRepository.findById(commentId).orElseThrow(() -> new NullPointerException("댓글을 찾을 수 없습니다."));
    }


}
