package com.sparta.spring_skill_review.domain;

public class AuthException extends RuntimeException {

    public AuthException(String message) {
        super(message);
    }
}