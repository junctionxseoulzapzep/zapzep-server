package com.example.zepzep.controller;

import com.example.zepzep.dto.ImageUrlDto;
import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ImageController {

    private final ImageService imageService;

    @GetMapping("/image/random")
    public ResponseDto<ImageUrlDto> getRandomZepetoImage(@RequestAttribute Long id) throws IOException {
        ImageUrlDto imageUrlDto = ImageUrlDto.of(imageService.getRandomZepetoImage(id));
        return ResponseDto.of(HttpStatus.OK, "success get Random my zepeto Image", imageUrlDto);
    }
}
