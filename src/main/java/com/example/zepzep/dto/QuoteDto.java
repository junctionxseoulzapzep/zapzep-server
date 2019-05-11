package com.example.zepzep.dto;

import com.example.zepzep.domain.Quote;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class QuoteDto {
    private String quote;

    QuoteDto(String quote) {
        this.quote = quote;
    }

    public static QuoteDto of(Quote quote) {
        return new QuoteDto(quote.getQuote());
    }

}
