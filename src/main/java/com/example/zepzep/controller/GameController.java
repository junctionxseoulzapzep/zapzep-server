package com.example.zepzep.controller;

import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.dto.ResponseDto;
import com.example.zepzep.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class GameController {
    private final GameService gameService;

    @GetMapping("test")
    public ResponseDto testGet(){
        return ResponseDto.of(HttpStatus.OK, "getMappingOK");
    }

    @PostMapping
    public ResponseDto saveGameResult(@RequestAttribute Long id,
                                      @RequestBody GameResultDto gameResultDto){
        this.gameService.saveGameResult(id,gameResultDto);
        return ResponseDto.of(HttpStatus.OK, "success!");
    }
}
