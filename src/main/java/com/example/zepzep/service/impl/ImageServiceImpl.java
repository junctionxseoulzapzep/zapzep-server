package com.example.zepzep.service.impl;

import com.example.zepzep.domain.User;
import com.example.zepzep.exception.UnauthorizedException;
import com.example.zepzep.repository.UserRepository;
import com.example.zepzep.service.ImageService;
import com.example.zepzep.utils.RandomGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    //    final ImageRepository imageRepository;
    final UserRepository userRepository;

    @Override
    @Transactional
    public String getRandomZepetoImage(Long userId) throws IOException {
        User user = userRepository.findById(userId)
                .orElseThrow(UnauthorizedException::new);
        String userHashCode = user.getHashCode();
        String zepetoId = RandomGenerator.getRandomZepetoId();

        return "http://47.74.149.35/api/photo/" + zepetoId + "/?hashCodes=" + userHashCode;
    }
}
