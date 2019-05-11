package com.example.zepzep.service;

import com.example.zepzep.domain.LandMark;
import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.dto.QuoteDto;
import com.example.zepzep.dto.RankerDto;

import java.io.IOException;
import java.util.List;

public interface GameService {

    void saveGameResult(Long userId, GameResultDto gameResultDto);

    RankerDto getLandmarksRanker(LandMark landMark);

    List<QuoteDto> getRandomTenQuoteList(Long id) throws IOException;
}
