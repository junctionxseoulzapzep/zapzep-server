package com.example.zepzep.dto;

import lombok.Value;

@Value
public class ImageUrlDto {
    private String url;

    private ImageUrlDto(String url) {
        this.url = url;
    }

    public static ImageUrlDto of(String url) {
        return new ImageUrlDto(url);
    }
}
