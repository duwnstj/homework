package com.sparta.spring_skill_review.domain.user.service;

import com.sparta.spring_skill_review.domain.user.dto.request.UserSaveRequestDto;
import com.sparta.spring_skill_review.domain.user.repository.UserRepository;
import com.sparta.spring_skill_review.domain.user.dto.response.UserGetResponseDto;
import com.sparta.spring_skill_review.domain.user.dto.response.UserSaveResponseDto;
import com.sparta.spring_skill_review.domain.user.dto.response.UsersGetResponseDto;
import com.sparta.spring_skill_review.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;



    // 유저 단건 조회
    public UserGetResponseDto getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NullPointerException("찾는 유저가없습니다."));
        return new UserGetResponseDto(
                user.getId(),
                user.getUserName(),
                user.getEmail()
        );
    }

    //유저 전체 조회
    public List<UsersGetResponseDto> getUsers() {

        List<User> getUsers = userRepository.findAll();

        return getUsers.stream()
                .map(users -> new UsersGetResponseDto(
                        users.getId(),
                        users.getUserName(),
                        users.getEmail()
                ))
                .collect(Collectors.toList());
    }

    //유저 삭제
    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
