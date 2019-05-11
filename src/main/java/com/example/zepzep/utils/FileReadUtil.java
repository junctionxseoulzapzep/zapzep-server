package com.example.zepzep.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class FileReadUtil {

    public static String readFile() throws IOException {
        StringBuilder builder = new StringBuilder();

        ClassPathResource cpr = new ClassPathResource("static/zepetoData.txt");
        byte[] bdata = FileCopyUtils.copyToByteArray(cpr.getInputStream());
        return new String(bdata, StandardCharsets.UTF_8);

//
//        try {
//            //파일 객체 생성
//            File file = new File("zepetoData.txt");
//            //입력 스트림 생성
//            Scanner scan = new Scanner(file);
//            while (scan.hasNextLine()) {
//                builder.append(scan.nextLine());
//            }
//            scan.close();
//
//        } catch (FileNotFoundException e) {
//            // TODO: handle exception
//        } catch (IOException e) {
//            System.out.println(e);
//        }
//        return builder.toString();

    }
}
