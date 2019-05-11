package com.example.zepzep.domain;

import com.example.zepzep.dto.GameResultDto;

import javax.persistence.*;

@Entity
public class GameResult {

    @Id
    @GeneratedValue
    @Column(name = "game_id")
    private Long id;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private LandMark landMark;

    private GameResult(Integer score, LandMark landMark ,User user){
        this.score = score;
        this.landMark = landMark;
        this.user = user;
    }

    public static GameResult of(GameResultDto gameResultDto, User user){
        return new GameResult(gameResultDto.getScore(),gameResultDto.getLandMark(),user);
    }

}
