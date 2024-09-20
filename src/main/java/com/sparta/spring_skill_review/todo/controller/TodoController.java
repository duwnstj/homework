package com.sparta.spring_skill_review.todo.controller;

import com.sparta.spring_skill_review.todo.dto.request.TodoSaveRequestDto;
import com.sparta.spring_skill_review.todo.dto.request.TodoUpdateRequestDto;
import com.sparta.spring_skill_review.todo.dto.response.TodoGetResponseDto;
import com.sparta.spring_skill_review.todo.dto.response.TodoSaveResponseDto;
import com.sparta.spring_skill_review.todo.dto.response.TodoUpdateResponseDto;
import com.sparta.spring_skill_review.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<TodoSaveResponseDto> saveTodo(@RequestBody TodoSaveRequestDto requestDto){

        return ResponseEntity.ok(todoService.saveTodo(requestDto));
    }

    /**
     * 일정 단건 조회
     * pathvaliable : 일정 id
     * response : 일정 id ,글쓴이, 일정 제목 , 일정 내용 , 일정작성일,일정수정일
     */

    @GetMapping("/{todoId}")
    public ResponseEntity<TodoGetResponseDto> getTodo(@PathVariable Long todoId){

        return ResponseEntity.ok(todoService.getTodo(todoId));
    }

    /**
     * 일정 수정
     * request : 일정 id , 일정 제목, 일정 내용
     * response : 일정 id , 글쓴이 , 일정 제목,일정 내용
     */

    @PutMapping
    public ResponseEntity<TodoUpdateResponseDto> updateTodo(@RequestBody TodoUpdateRequestDto requestDto){

        return ResponseEntity.ok(todoService.updateTodo(requestDto));
    }
}
