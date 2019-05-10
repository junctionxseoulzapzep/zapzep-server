package com.example.zepzep.domain;

import com.example.zepzep.dto.UserDto;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String hashCode;

    private Double latitude;

    private Double longitude;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameResult> gameResult;


    protected User(){

    }

    private User(String name, String hashCode){
        this.name = name;
        this.hashCode = hashCode;
    }

    public static User of(UserDto userDto){
        return new User(userDto.getName(),userDto.getHashCode());
    }



}
