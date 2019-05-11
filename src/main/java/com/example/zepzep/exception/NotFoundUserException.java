package com.example.zepzep.exception;

public class NotFoundUserException extends RuntimeException {
    public NotFoundUserException(){
        super("Not Found User!");
    }
}
