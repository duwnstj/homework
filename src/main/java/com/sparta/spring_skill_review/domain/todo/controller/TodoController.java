package com.sparta.spring_skill_review.domain.todo.controller;

import com.sparta.spring_skill_review.domain.common.annotaiton.Auth;
import com.sparta.spring_skill_review.domain.common.dto.AuthUser;
import com.sparta.spring_skill_review.domain.todo.dto.request.TodoSaveRequestDto;
import com.sparta.spring_skill_review.domain.todo.dto.request.TodoUpdateRequestDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodoGetResponseDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodoSaveResponseDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodoUpdateResponseDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodosGetResponseDto;
import com.sparta.spring_skill_review.domain.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/todos")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    /**
     * 일정 저장
     * request : 일정 제목 , 일정내용
     * response : 일정 id , 일정 제목 ,글쓴이, 일정내용
     */
    @PostMapping
    public ResponseEntity<TodoSaveResponseDto> saveTodo(
            @RequestBody TodoSaveRequestDto requestDto,
            @Auth AuthUser authUser) {

        return ResponseEntity.ok(todoService.saveTodo(requestDto,authUser));
    }

    /**
     * 일정 단건 조회
     * pathvaliable : 일정 id
     * response : 일정 id ,글쓴이, 일정 제목 , 일정 내용 , 일정작성일,일정수정일
     */

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoGetResponseDto> getTodo(@PathVariable Long todoId) {

        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    /**
     * 일정 수정
     * request : 일정 id , 일정 제목, 일정 내용
     * response : 일정 id , 글쓴이 , 일정 제목,일정 내용
     */

    @PutMapping
    public ResponseEntity<TodoUpdateResponseDto> updateTodo(@RequestBody TodoUpdateRequestDto requestDto) {

        return ResponseEntity.ok(todoService.updateTodo(requestDto));
    }

    /**
     * 해당하는 일정 페이지 조회
     * response : 할일 제목, 할일 내용, 댓글 개수, 일정 작성일, 일정 수정일, 일정 작성 유저명
     */
    @GetMapping
    public ResponseEntity<Page<TodosGetResponseDto>> getTodos(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(todoService.getTodos(page,size));
    }

    /**
     * 일정 삭제
     */
    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId){
        todoService.deleteTodo(todoId);
    }
}
