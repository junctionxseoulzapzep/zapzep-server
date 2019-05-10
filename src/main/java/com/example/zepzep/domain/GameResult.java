package com.example.zepzep.domain;

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

}
