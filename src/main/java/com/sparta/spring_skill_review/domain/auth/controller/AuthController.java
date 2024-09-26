package com.sparta.spring_skill_review.domain.auth.controller;

import com.sparta.spring_skill_review.domain.auth.dto.request.SignInRequestDto;
import com.sparta.spring_skill_review.domain.auth.dto.request.SignUpRequestDto;
import com.sparta.spring_skill_review.domain.auth.dto.response.SignInResponseDto;
import com.sparta.spring_skill_review.domain.auth.dto.response.SignUpResponseDto;
import com.sparta.spring_skill_review.domain.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    /**
     * 회원 가입
     * request : 이메일,비밀번호
     * response : token
     */
    @PostMapping("/auth/signup")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto requestDto){
        return authService.signup(requestDto);
    }

    /**
     *  로그인
     *  request : 이메일 , userName, 비밀번호
     *  response : token
     *
     */
    @PostMapping("/auth/signin")
    public SignInResponseDto signIn(@RequestBody SignInRequestDto requestDto){
        return authService.signIn(requestDto);
    }
}
