package com.example.zepzep.service.impl;

import com.example.zepzep.domain.User;
import com.example.zepzep.dto.UserDto;
import com.example.zepzep.repository.UserRepository;
import com.example.zepzep.service.UserService;
import com.example.zepzep.utils.JwtFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtFactory jwtFactory;

    @Override
    @Transactional
    public String createUser(UserDto userDto){
        User user = User.of(userDto);
        this.userRepository.save(user);
        return this.jwtFactory.generateToken(user);
    }


}
