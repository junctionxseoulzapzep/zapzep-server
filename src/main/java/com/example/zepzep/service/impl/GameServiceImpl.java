package com.example.zepzep.service.impl;

import com.example.zepzep.domain.*;
import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.dto.QuoteDto;
import com.example.zepzep.exception.UnauthorizedException;
import com.example.zepzep.repository.GameResultRepository;
import com.example.zepzep.repository.UserRepository;
import com.example.zepzep.service.GameService;
import com.example.zepzep.utils.HttpConnector;
import com.example.zepzep.utils.JsonParser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final GameResultRepository gameResultRepository;
    private final UserRepository userRepository;
    private final HttpConnector httpConnector;

    @Transactional
    public void saveGameResult(Long userId, GameResultDto gameResultDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(UnauthorizedException::new);

        gameResultRepository.save(GameResult.of(gameResultDto, user));
//
//
//
//        GameResult gameResult = gameResultRepository
//
//
//        validateRanker(gameResultDto, user);
    }

//    public void validateRanker(GameResultDto myGameResultDto, User user){
//        Ranker topRanker = rankerRepository.
//                findByLandMark(myGameResultDto.getLandMark())
//                .orElse(rankerRepository.save(Ranker.of(myGameResultDto, user)));
//        if(topRanker.getScore() < myGameResultDto.getScore()){
//            topRanker.setScore(myGameResultDto.getScore());
//        }
//    }
//
//    @Transactional
//    public RankerDto getLandmarksRanker(LandMark landMark){
//        Ranker ranker = rankerRepository.findByLandMark(landMark)
//                .orElseThrow(NotFoundException::new);
//        return RankerDto.of(ranker);
//    }

    public GameResultDto getLandmarksRanker(String landMark){
        GameResult topUser = gameResultRepository.findFirstByLandMarkOrderByScoreDesc(landMark);
        return GameResultDto.of(topUser, topUser.getUser());
    }

    @Override
    public List<QuoteDto> getRandomTenQuoteList(Long id) throws IOException {
        String quoteString = httpConnector.getFamousQuote();
        List<Quote> myObjects = JsonParser.jsonToQuoteList(quoteString);

        return myObjects.stream()
                .map(q -> QuoteDto.of(q))
                .collect(Collectors.toList());
    }


}
