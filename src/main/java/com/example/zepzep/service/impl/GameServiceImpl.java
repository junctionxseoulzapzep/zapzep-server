package com.example.zepzep.service.impl;

import com.example.zepzep.domain.GameResult;
import com.example.zepzep.domain.User;
import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.exception.UnauthorizedException;
import com.example.zepzep.repository.GameResultRepository;
import com.example.zepzep.repository.UserRepository;
import com.example.zepzep.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private static GameResultRepository gameResultRepository;
    private static UserRepository userRepository;

    @Transactional
    public void saveGameResult(Long userId, GameResultDto gameResultDto){
        User user = userRepository.findById(userId)
                .orElseThrow(UnauthorizedException::new);

        gameResultRepository.save(GameResult.of(gameResultDto, user));


    }
}
