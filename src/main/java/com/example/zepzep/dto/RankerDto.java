package com.example.zepzep.dto;

import com.example.zepzep.domain.LandMark;
import com.example.zepzep.domain.Ranker;
import com.example.zepzep.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RankerDto {
    private Integer score;
    private LandMark landMark;
    private User user;

    private RankerDto(Ranker ranker) {
        this.score = ranker.getScore();
        this.landMark = ranker.getLandMark();
        this.user = ranker.getUser();
    }

    public static RankerDto of(Ranker ranker) {
        return new RankerDto(ranker);
    }
}
