package com.example.zepzep.controller;

import com.example.zepzep.dto.UserLocationDto;
import com.example.zepzep.message.UserLocationMessage;
import com.example.zepzep.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class LocationController {

    private final LocationService locationService;

    @MessageMapping("/get_location/{userId}")
    @SendTo("/topic/send_location")
    public List<UserLocationDto> getLocation(@DestinationVariable(value = "userId") Long id,
                                             UserLocationMessage message) throws Exception {

        return this.locationService.getUsers(message,id);
        
    }
}
