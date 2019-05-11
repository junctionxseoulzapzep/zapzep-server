package com.example.zepzep.dto;

import com.example.zepzep.domain.GameResult;
import com.example.zepzep.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GameResultDto {
    private Integer score;
    private String landMark;
    //    private String name;
    private String name;
    private String zepeto;

    private GameResultDto(GameResult gameResult, User user) {
        this.score = gameResult.getScore();
        this.landMark = gameResult.getLandMark();
        this.name = user.getName();
        this.zepeto = user.getZepetoImageFile();
    }

    public static GameResultDto of(GameResult gameResult, User user) {
        return new GameResultDto(gameResult, user);
    }
}
