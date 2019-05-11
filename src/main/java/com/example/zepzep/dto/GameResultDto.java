package com.example.zepzep.dto;

import com.example.zepzep.domain.LandMark;
import lombok.Value;

@Value
public class GameResultDto {
    private Integer score;
    private LandMark landMark;
}
