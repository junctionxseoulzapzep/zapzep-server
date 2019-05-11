package com.example.zepzep.service;

import com.example.zepzep.dto.UserLocationDto;
import com.example.zepzep.message.UserLocationMessage;

import java.util.List;

public interface LocationService {

    List<UserLocationDto> getUsers(UserLocationMessage locationMessage, Long id);
}
