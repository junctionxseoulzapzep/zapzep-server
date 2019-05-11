package com.example.zepzep.dto;

import com.example.zepzep.domain.LandMark;
import lombok.*;

@Getter
@NoArgsConstructor
public class GameResultDto {
    private Integer score;
    private LandMark landMark;
}
