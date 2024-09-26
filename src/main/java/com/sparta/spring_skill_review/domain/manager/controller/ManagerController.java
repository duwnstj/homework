package com.sparta.spring_skill_review.domain.manager.controller;

import com.sparta.spring_skill_review.domain.common.annotaiton.Auth;
import com.sparta.spring_skill_review.domain.common.dto.AuthUser;
import com.sparta.spring_skill_review.domain.manager.service.ManagerService;
import com.sparta.spring_skill_review.domain.manager.dto.request.ManagerSaveRequestDto;
import com.sparta.spring_skill_review.domain.manager.dto.response.ManagerSaveResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagerController {

    private final ManagerService managerService;

    /**
     * 매니저 등록하는 로직
     * PathValiable : todoId
     * request: manageruserId
     * response : managerUserId
     */
    @PostMapping("/todos/{todoId}/users")
    public ResponseEntity<ManagerSaveResponseDto> saveManager(
            @RequestBody ManagerSaveRequestDto requestDto,
            @PathVariable Long todoId,
            @Auth AuthUser authUser) {
        return ResponseEntity.ok(managerService.saveManager(requestDto,todoId,authUser));
    }


}
