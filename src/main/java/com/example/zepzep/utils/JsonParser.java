package com.example.zepzep.utils;

import com.example.zepzep.domain.Quote;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class JsonParser {

    public static List<Quote> jsonToQuoteList(String jsonString) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        List<Quote> myObjects = mapper.readValue(jsonString, new TypeReference<List<Quote>>() {
        });
        return myObjects;
    }

}
