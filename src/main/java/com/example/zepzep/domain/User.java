package com.example.zepzep.domain;

import com.example.zepzep.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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

    private String zepetoImageFile;

    protected User(){

    }

    private User(String name, String hashCode, String zepetoImageFile){
        this.name = name;
        this.hashCode = hashCode;
        this.zepetoImageFile = zepetoImageFile;
    }

    public static User of(UserDto userDto){
        return new User(userDto.getName(),
                userDto.getHashCode(),
                userDto.getZepetoImageFile());
    }

}
