package com.example.zepzep.controller;

import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GameController {
    private final GameService gameService;

    @PostMapping
    public ResponseDto saveGameResult(@RequestAttribute Long id,
                                      @RequestBody GameResultDto gameResultDto){
        this.gameService.saveGameResult(id,gameResultDto);
        return ResponseDto.of(HttpStatus.OK, "success!");
    }
}
