package com.example.zepzep.service;

import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.dto.QuoteDto;

import java.io.IOException;
import java.util.List;

public interface GameService {

    void saveGameResult(Long userId, GameResultDto gameResultDto);

    List<QuoteDto> getRandomTenQuoteList(Long id) throws IOException;
}
