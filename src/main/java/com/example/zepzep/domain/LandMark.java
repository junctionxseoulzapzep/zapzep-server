package com.example.zepzep.domain;

import java.util.Arrays;

public enum LandMark {

    GYEONGBOKGUNG("경복궁",37.5796, 126.9770),
    YONGSAN("용산", 37.5334, 126.9791),
    GWANGHWAMUN("광화문", 37.5759, 126.9768);

    private Double latitude, longitude;
    private String name;

    LandMark(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static LandMark getLandMarkByName(String landMarkName) {
        return Arrays.asList(LandMark.values()).stream()
                .filter(l -> l.toString() == landMarkName)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getName() {
        return name;
    }
}
