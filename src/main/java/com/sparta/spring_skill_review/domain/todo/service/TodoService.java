package com.sparta.spring_skill_review.domain.todo.service;

import com.sparta.spring_skill_review.domain.manager.dto.response.ManagerResponseDto;
import com.sparta.spring_skill_review.domain.manager.entity.Manager;
import com.sparta.spring_skill_review.domain.manager.repository.ManagerRepository;
import com.sparta.spring_skill_review.domain.todo.dto.request.TodoSaveRequestDto;
import com.sparta.spring_skill_review.domain.todo.dto.request.TodoUpdateRequestDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodoGetResponseDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodoSaveResponseDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodoUpdateResponseDto;
import com.sparta.spring_skill_review.domain.todo.dto.response.TodosGetResponseDto;
import com.sparta.spring_skill_review.domain.todo.entity.Todo;
import com.sparta.spring_skill_review.domain.todo.repository.TodoRepository;
import com.sparta.spring_skill_review.domain.user.entity.User;
import com.sparta.spring_skill_review.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;


    //일정 저장
    @Transactional
    public TodoSaveResponseDto saveTodo(TodoSaveRequestDto requestDto) {

        User user = userRepository.findById(requestDto.getWriterUserId())
                .orElseThrow(() -> new NullPointerException("해당 유저를 찾을 수 없습니다."));
        Todo todo = new Todo(
                user,
                requestDto.getTitle(),
                requestDto.getContent()
        );
        todoRepository.save(todo);

        return new TodoSaveResponseDto(
                todo.getId(),
                todo.getUser().getUserName(),
                todo.getTitle(),
                todo.getContent()

        );
    }


    //일정 단건 조회
    public TodoGetResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NullPointerException("찾는 일정이 없습니다"));
        List<Manager> managerList = managerRepository.findByTodoIdWithUser(todoId);

        List<ManagerResponseDto> managerDtoList = managerList.stream()
                .map(managers -> new ManagerResponseDto(
                        managers.getId(),
                        managers.getUser().getUserName(),
                        managers.getUser().getEmail()
                ))
                .collect(Collectors.toList());

        return new TodoGetResponseDto(
                todo.getId(),
                todo.getUser().getUserName(),
                todo.getTitle(),
                todo.getContent(),
                todo.getCreateAt(),
                todo.getModifiedAt(),
                managerDtoList
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
                todo.getUser().getUserName(),
                todo.getTitle(),
                todo.getContent()
        );


    }

    //페이징 처리 후 일정 전체 조회
    public Page<TodosGetResponseDto> getTodos(int page, int size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Todo> pagingTodos = todoRepository.findAllByOrderByModifiedAtDesc(pageable);

        return pagingTodos.map(todo -> new TodosGetResponseDto(
                todo.getTitle(),
                todo.getContent(),
                todo.getCommentList().size(),
                todo.getCreateAt(),
                todo.getModifiedAt(),
                todo.getUser().getUserName()
        ));

    }

    //일정 삭제
    @Transactional
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    //일정 id 찾기
    public Todo findTodo(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(() -> new NullPointerException("찾는 일정이 없습니다."));
    }
}
