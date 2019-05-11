package com.example.zepzep.controller;

import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.exception.NotFoundUserException;
import com.example.zepzep.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseDto handleExistUserException() {
        return ResponseDto.of(HttpStatus.NOT_ACCEPTABLE, "unauthorization!!");
    }


    @ExceptionHandler(NotFoundUserException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseDto handleNotFoundException(){
        return ResponseDto.of(HttpStatus.NOT_FOUND,"Not Found User!");
    }
}
