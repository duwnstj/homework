package com.sparta.spring_skill_review.todo.service;

import com.sparta.spring_skill_review.todo.dto.request.TodoSaveRequestDto;
import com.sparta.spring_skill_review.todo.dto.request.TodoUpdateRequestDto;
import com.sparta.spring_skill_review.todo.dto.response.TodoGetResponseDto;
import com.sparta.spring_skill_review.todo.dto.response.TodoSaveResponseDto;
import com.sparta.spring_skill_review.todo.dto.response.TodoUpdateResponseDto;
import com.sparta.spring_skill_review.todo.entity.Todo;
import com.sparta.spring_skill_review.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TodoService {
    private final TodoRepository todoRepository;


    //일정 저장
    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {
        Todo todo = new Todo(
                requestDto.getWriterName(),
                requestDto.getTitle(),
                requestDto.getContent()
        );
        todoRepository.save(todo);

        return new TodoSaveResponseDto(
                todo.getId(),
                todo.getWriterName(),
                todo.getTitle(),
                todo.getContent()

        );
    }


    //일정 단건 조회
    public TodoGetResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NullPointerException("찾는 일정이 없습니다"));

        return new TodoGetResponseDto(
                todo.getId(),
                todo.getWriterName(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreateAt(),
                todo.getModifiedAt()
        );
    }

    //일정 수정
    @Transactional
    public TodoUpdateResponseDto updateTodo(TodoUpdateRequestDto requestDto) {

        Todo todo = findTodo(requestDto.getId());

        todo.update(
                requestDto.getTitle(),
                requestDto.getContent()
        );

        return new TodoUpdateResponseDto(
                todo.getId(),
                todo.getWriterName(),
                todo.getTitle(),
                todo.getContent()
        );


    }

    //일정 id 찾기
    public Todo findTodo(Long todoId){
        return todoRepository.findById(todoId).orElseThrow(()->new NullPointerException("찾는 일정이 없습니다."));
    }
}
