package com.example.zepzep.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }
    public NotFoundException(String message) {
        super(message);
    }
}
