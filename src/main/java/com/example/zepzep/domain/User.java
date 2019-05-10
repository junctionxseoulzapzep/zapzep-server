package com.example.zepzep.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String hashCode;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameResult> gameResult;



}
