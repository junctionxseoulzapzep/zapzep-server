package com.example.zepzep.service;

import com.example.zepzep.domain.User;
import com.example.zepzep.dto.UserDto;

public interface UserService {
    String createUser(UserDto userDto);

    User getUserById(long id);
}
