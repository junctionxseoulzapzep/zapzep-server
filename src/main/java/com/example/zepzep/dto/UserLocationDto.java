package com.example.zepzep.dto;

import com.example.zepzep.domain.User;
import lombok.Value;

@Value
public class UserLocationDto {
    private Long id;
    private String name;
    private String hashCode;
    private Double latitude;
    private Double longitude;

    private UserLocationDto(Long id,String name,String hashCode,Double latitude,Double longitude){
        this.id = id;
        this.name = name;
        this.hashCode = hashCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static UserLocationDto of(User user){
        return new UserLocationDto(user.getId(),
                                    user.getName(),
                                    user.getHashCode(),
                                    user.getLatitude(),
                                    user.getLongitude());
    }
}
