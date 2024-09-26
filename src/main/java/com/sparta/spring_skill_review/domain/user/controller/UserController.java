package com.sparta.spring_skill_review.domain.user.controller;

import com.sparta.spring_skill_review.domain.common.annotaiton.Auth;
import com.sparta.spring_skill_review.domain.common.dto.AuthUser;
import com.sparta.spring_skill_review.domain.user.dto.request.UserSaveRequestDto;
import com.sparta.spring_skill_review.domain.user.dto.response.UserGetResponseDto;
import com.sparta.spring_skill_review.domain.user.dto.response.UserSaveResponseDto;
import com.sparta.spring_skill_review.domain.user.dto.response.UsersGetResponseDto;
import com.sparta.spring_skill_review.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    /**
     * 유저 단건 조회
     * pathValiable : userId
     * response : userId,userName,email
     */
    @GetMapping
    public ResponseEntity<UserGetResponseDto> getUser(@Auth AuthUser authUser){

        return ResponseEntity.ok(userService.getUser(authUser));
    }

    /**
     * 유저 전체 조회
     * response : userId, userName,email
     */
    @GetMapping
    public ResponseEntity<List<UsersGetResponseDto>> getUsers(){

        return ResponseEntity.ok(userService.getUsers());
    }

    /**
     * 유저 삭제
     * pathValiable : userId
     */
    @DeleteMapping
    public void deleteUser(@Auth AuthUser authUser){
        userService.deleteUser(authUser);
    }


}
