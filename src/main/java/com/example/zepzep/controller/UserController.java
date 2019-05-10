package com.example.zepzep.controller;

import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.dto.UserDto;
import com.example.zepzep.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/join")
    public ResponseDto join(@RequestBody UserDto userDto){
        this.userService.createUser(userDto);
        return ResponseDto.of(HttpStatus.OK,"success create user!");
    }

}
