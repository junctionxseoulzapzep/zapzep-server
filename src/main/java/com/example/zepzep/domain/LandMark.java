package com.example.zepzep.domain;

public enum LandMark {

    GYEONGBOKGUNG("경복궁",37.5796,126.9770),
    GWANGHWAMUN("광화문",37.5759,126.9768);


    private Double latitude,longitude;
    private String name;


    LandMark(String name, Double latitude, Double longitude){
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

}
