package com.example.zepzep.service;

import com.example.zepzep.dto.GameResultDto;

import java.io.IOException;

public interface ImageService {

    String getRandomZepetoImage(Long userId) throws IOException;

}
