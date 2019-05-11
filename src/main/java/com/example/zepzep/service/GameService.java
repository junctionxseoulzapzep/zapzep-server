package com.example.zepzep.service;

import com.example.zepzep.dto.GameResultDto;

public interface GameService {

    void saveGameResult(Long userId, GameResultDto gameResultDto);

}
