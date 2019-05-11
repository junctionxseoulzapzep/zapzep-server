package com.example.zepzep.domain;

import com.example.zepzep.dto.GameResultDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class GameResult {

    @Id
    @GeneratedValue
    @Column(name = "game_id")
    private Long id;

    private Integer score;

    private String landMark;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

//    @Enumerated(EnumType.STRING)

    private GameResult(GameResultDto gameResultDto ,User user){
        this.score = gameResultDto.getScore();
        this.landMark = gameResultDto.getLandMark();
        this.user = user;
    }

    public static GameResult of(GameResultDto gameResultDto, User user){
        return new GameResult(gameResultDto,user);
    }

}
