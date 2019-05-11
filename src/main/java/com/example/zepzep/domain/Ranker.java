package com.example.zepzep.domain;

import com.example.zepzep.dto.GameResultDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ranker {

    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private LandMark landMark;

    private Integer score;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Ranker(Integer score, LandMark landMark ,User user){
        this.score = score;
        this.landMark = landMark;
        this.user = user;
    }

    public static Ranker of(GameResultDto gameResultDto, User user){
        return new Ranker(gameResultDto.getScore(),gameResultDto.getLandMark(),user);
    }
}
