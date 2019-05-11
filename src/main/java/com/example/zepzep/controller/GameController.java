package com.example.zepzep.controller;

import com.example.zepzep.domain.LandMark;
import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.dto.QuoteDto;
import com.example.zepzep.dto.RankerDto;
import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/game")
public class GameController {
    private final GameService gameService;

    @PostMapping
    public ResponseDto saveGameResult(@RequestAttribute Long id,
                                      @RequestBody GameResultDto gameResultDto) {
        this.gameService.saveGameResult(id, gameResultDto);
        return ResponseDto.of(HttpStatus.OK, "success!");
    }

    @GetMapping("quote")
    public ResponseDto getRandomTenQuoteList(@RequestAttribute Long id) throws IOException {
        List<QuoteDto> quotes = this.gameService.getRandomTenQuoteList(id);
        return ResponseDto.of(HttpStatus.OK, "Get 10 quote list", quotes);
    }

    @GetMapping("winner")
    public ResponseDto getWinnerOfSpecificLandMark(@RequestAttribute Long id,
                                                   @RequestParam(value="landmark", required = true) String landMarkName){

        RankerDto rankerDto = this.gameService.getLandmarksRanker(LandMark.getLandMarkByName(landMarkName));
        return ResponseDto.of(HttpStatus.OK, "landmark winner 탐색 완료", rankerDto);
    }
}
