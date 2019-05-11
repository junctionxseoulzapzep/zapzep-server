package com.example.zepzep.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileReadUtil {

    public static String readFile() throws IOException {
        StringBuilder builder = new StringBuilder();

        ClassPathResource cpr = new ClassPathResource("static/zepetoData.txt");
        byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
        return new String(bdata, StandardCharsets.UTF_8);
    }
}
