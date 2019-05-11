package com.example.zepzep.message;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLocationMessage {

    private Double latitude;

    private Double longitude;


    public UserLocationMessage(Double latitude, Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
