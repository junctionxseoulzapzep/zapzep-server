package com.example.zepzep.controller;

import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.exception.NotFoundException;
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

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseDto handleNotFoundRankerException() {
        return ResponseDto.of(HttpStatus.ACCEPTED, "해당 랜드마크에 랭커가 없습니다.");
    }




}
