package com.sparta.spring_skill_review.domain.auth.service;

import com.sparta.spring_skill_review.config.JwtUtil;
import com.sparta.spring_skill_review.config.PasswordEncoder;
import com.sparta.spring_skill_review.domain.AuthException;
import com.sparta.spring_skill_review.domain.auth.dto.request.SignInRequestDto;
import com.sparta.spring_skill_review.domain.auth.dto.request.SignUpRequestDto;
import com.sparta.spring_skill_review.domain.auth.dto.response.SignInResponseDto;
import com.sparta.spring_skill_review.domain.auth.dto.response.SignUpResponseDto;
import com.sparta.spring_skill_review.domain.common.exception.InvalidRequestException;
import com.sparta.spring_skill_review.domain.user.entity.User;
import com.sparta.spring_skill_review.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignUpResponseDto signup(SignUpRequestDto signupRequest) {
        String email = signupRequest.getEmail();

        if (userRepository.existsByEmail(email)) {
            throw new InvalidRequestException("이미 존재하는 이메일입니다.");
        }


        String encodedPassword = passwordEncoder.encode(signupRequest.getPassword());

        User newUser = new User(
                signupRequest.getEmail(),
                signupRequest.getUserName(),
                encodedPassword
        );
        User savedUser = userRepository.save(newUser);

        String bearerToken = jwtUtil.createToken(savedUser.getId(), savedUser.getEmail());

        return new SignUpResponseDto(bearerToken);
    }

    // 로그인
    public SignInResponseDto signIn(SignInRequestDto signinRequest) {
        User user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow(
                () -> new InvalidRequestException("가입되지 않은 유저입니다."));

        // 로그인 시 이메일과 비밀번호가 일치하지 않을 경우 401을 반환합니다.
        if (!passwordEncoder.matches(signinRequest.getPassword(), user.getPassword())) {
            throw new AuthException("잘못된 비밀번호입니다.");
        }

        String bearerToken = jwtUtil.createToken(user.getId(), user.getEmail());

        return new SignInResponseDto(bearerToken);
    }
}
