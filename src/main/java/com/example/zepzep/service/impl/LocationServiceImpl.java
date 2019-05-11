package com.example.zepzep.service.impl;

import com.example.zepzep.domain.User;
import com.example.zepzep.dto.UserLocationDto;
import com.example.zepzep.exception.NotFoundUserException;
import com.example.zepzep.message.UserLocationMessage;
import com.example.zepzep.repository.UserRepository;
import com.example.zepzep.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final UserRepository userRepository;

    @Transactional
    public List<UserLocationDto> getUsers(UserLocationMessage locationMessage, Long id){
        User user = this.userRepository.findById(id)
                        .orElseThrow(NotFoundUserException::new);

        user.setLatitude(locationMessage.getLatitude());
        user.setLongitude(locationMessage.getLongitude());

        this.userRepository.save(user);


        List<User> users = this.userRepository.findAll();

        List<UserLocationDto> userLocationDtos = users.stream()
                .filter(u -> distFrom(u.getLatitude(),u.getLongitude(),user.getLatitude(),user.getLongitude()))
                .map(UserLocationDto::of)
                .collect(Collectors.toList());

        return userLocationDtos;

    }

    private boolean distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        if(dist < 5.0f)
            return true;
        else
            return false;
    }
}
