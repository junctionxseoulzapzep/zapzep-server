package com.example.zepzep.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class RandomGenerator {

    public static final int RANDOM_SELECT_NUMBER = 0;

    public static String getRandomZepetoId() throws IOException {
//
//        File string = new File("C:\\Users\\mor22\\zepzap-server\\src\\main\\resources\\static\\zepetoData.txt");
//        string.mapper.getTypeFactory().constructCollectionType(List.class, String.class));

        List<String> fileData = Arrays.asList(FileReadUtil.readFile().split(","));
        Collections.shuffle(fileData);
        return fileData.get(RANDOM_SELECT_NUMBER);
    }

}
