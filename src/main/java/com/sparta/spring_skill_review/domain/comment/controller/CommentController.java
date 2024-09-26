package com.sparta.spring_skill_review.domain.comment.controller;

import com.sparta.spring_skill_review.domain.comment.dto.request.CommentUpdateRequestDto;
import com.sparta.spring_skill_review.domain.comment.dto.request.PostCommentSaveRequestDto;
import com.sparta.spring_skill_review.domain.comment.dto.response.CommentGetResponseDto;
import com.sparta.spring_skill_review.domain.comment.dto.response.CommentUpdateResponseDto;
import com.sparta.spring_skill_review.domain.comment.dto.response.CommentsGetResponseDto;
import com.sparta.spring_skill_review.domain.comment.dto.response.PostCommentSaveResponseDto;
import com.sparta.spring_skill_review.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 저장
     * pathvalialbe : 일정 id
     * request : 댓글 내용 ,댓글 작성자
     * response : 일정 id , 댓글 내용 댓글 작성자
     */
    @PostMapping("/comments/todos/{todoId}")
    public ResponseEntity<PostCommentSaveResponseDto> saveComment(
            @RequestBody PostCommentSaveRequestDto requestDto,
            @PathVariable Long todoId) {
        return ResponseEntity.ok(commentService.saveComment(requestDto, todoId));
    }

    /**
     * 댓글 단건 조회
     * pathvaliable : 댓글 id
     * response : 댓글 id , 댓글 내용 ,댓글 작성자
     */
    @GetMapping("/comments/{commentId}")
    public ResponseEntity<CommentGetResponseDto> getComment(@PathVariable Long commentId){

        return ResponseEntity.ok(commentService.getComment(commentId));
    }

    /**
     * 일정에 해당하는 댓글 전체 조회
     * pathvaliable : 일정 id
     * response : 댓글 id,댓글 작성자, 댓글 내용
     */
    @GetMapping("/comments/todos/{todoId}")
    public ResponseEntity<List<CommentsGetResponseDto>> getComments(@PathVariable Long todoId){

        return ResponseEntity.ok(commentService.getComments(todoId));
    }

    /**
     * 댓글 수정
     * pathvaliable : 댓글 id
     * request : 댓글 내용
     * response : 댓글 id 댓글 작성자, 댓글 내용
     */
    @PutMapping("/comments/{commentId}")
    public ResponseEntity<CommentUpdateResponseDto> updateComment(
            @PathVariable Long commentId,
            @RequestBody CommentUpdateRequestDto requestDto){

        return ResponseEntity.ok(commentService.updateComment(commentId,requestDto));
    }

    /**
     * 댓글 삭제
     * pathValiable : 댓글 id
     *
     */
    @DeleteMapping("comments/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }

}
