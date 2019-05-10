package com.example.zepzep.service.impl;

import com.example.zepzep.domain.User;
import com.example.zepzep.dto.UserDto;
import com.example.zepzep.repository.UserRepository;
import com.example.zepzep.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public void createUser(UserDto userDto){
        this.userRepository.save(User.of(userDto));
    }


}
