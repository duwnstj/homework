package com.sparta.spring_skill_review.domain.manager.service;

import com.sparta.spring_skill_review.domain.manager.dto.request.ManagerSaveRequestDto;
import com.sparta.spring_skill_review.domain.manager.dto.response.ManagerSaveResponseDto;
import com.sparta.spring_skill_review.domain.manager.entity.Manager;
import com.sparta.spring_skill_review.domain.manager.repository.ManagerRepository;
import com.sparta.spring_skill_review.domain.todo.entity.Todo;
import com.sparta.spring_skill_review.domain.todo.repository.TodoRepository;
import com.sparta.spring_skill_review.domain.user.entity.User;
import com.sparta.spring_skill_review.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    //매니저 저장
    @Transactional
    public ManagerSaveResponseDto saveManager(ManagerSaveRequestDto requestDto, Long todoId, Long userId) {
        User managerUser = userRepository.findById(requestDto.getManagerUserId())
                .orElseThrow(() -> new NullPointerException("찾는 유저가 없습니다."));

        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new NullPointerException("찾는 일정이 없습니다."));
        if (!(ObjectUtils.nullSafeEquals(todo.getUser().getId(), userId))) {
            throw new IllegalArgumentException("매니저를 등록할 권한이 없습니다.");
        }
        Manager newmanager = new Manager(managerUser, todo);
        Manager saveManager = managerRepository.save(newmanager);

        return new ManagerSaveResponseDto(
                saveManager.getId()
        );
    }
}
