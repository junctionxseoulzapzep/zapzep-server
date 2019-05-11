package com.example.zepzep.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Quote {
    private String quote;
    private String author;
    private String category;
}
