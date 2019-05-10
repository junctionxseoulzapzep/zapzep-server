package com.example.zepzep.controller;

import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiControllerAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseDto handleExistUserException() {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "unauthorization!!");
    }

}
