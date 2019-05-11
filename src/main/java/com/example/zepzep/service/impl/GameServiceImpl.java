package com.example.zepzep.service.impl;

import com.example.zepzep.domain.GameResult;
import com.example.zepzep.domain.Quote;
import com.example.zepzep.domain.User;
import com.example.zepzep.dto.GameResultDto;
import com.example.zepzep.dto.QuoteDto;
import com.example.zepzep.exception.UnauthorizedException;
import com.example.zepzep.repository.GameResultRepository;
import com.example.zepzep.repository.UserRepository;
import com.example.zepzep.service.GameService;
import com.example.zepzep.utils.HttpConnector;
import com.example.zepzep.utils.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
