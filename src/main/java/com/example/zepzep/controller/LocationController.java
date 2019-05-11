package com.example.zepzep.controller;

import com.example.zepzep.dto.UserLocationDto;
import com.example.zepzep.message.UserLocationMessage;
import com.example.zepzep.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*
* 소켓 통신 입니다.
* */
@RestController
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @MessageMapping("/get_location/{userId}")
    @SendTo("/topic/send_location")
    public List<UserLocationDto> getLocation(@DestinationVariable(value = "userId") Long id,
                                             UserLocationMessage message) throws Exception {

        return this.locationService.getUsers(message,id);
    }

    @PostMapping("api/get_location/{userId}")
    public List<UserLocationDto> getLocationUseRest(@RequestAttribute Long id,
                                                    @RequestBody UserLocationMessage message) {

        return this.locationService.getUsers(message,id);
    }

}
