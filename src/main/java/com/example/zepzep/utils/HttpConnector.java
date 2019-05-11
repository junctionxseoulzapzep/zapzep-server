package com.example.zepzep.utils;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class HttpConnector {

    //@Value("${rapid.api.key}")
    public static String rapidAPiKey = "49f290f37emsh769ec00e95f1456p19e0c8jsn8e2351eb3917";


    public String getFamousQuote() {

        String body = "";

        try {
            HttpClient client = HttpClientBuilder.create().build(); // HttpClient 생성
            HttpGet getRequest = new HttpGet("https://andruxnet-random-famous-quotes.p.rapidapi.com/?count=5"); //GET 메소드 URL 생성
            getRequest.addHeader("X-RapidAPI-Host", "andruxnet-random-famous-quotes.p.rapidapi.com");
            getRequest.addHeader("X-RapidAPI-Key", rapidAPiKey);

            HttpResponse response = client.execute(getRequest);

            //Response 출력
            if (response.getStatusLine().getStatusCode() == 200) {
                ResponseHandler<String> handler = new BasicResponseHandler();
                body = handler.handleResponse(response);
                System.out.println(body);
            } else {
                log.error("response is error : " + response.getStatusLine().getStatusCode());
                log.error("response is error : " + response.getEntity().toString());
                response.getEntity();
            }

        } catch (Exception e) {
            log.error(e.toString());
        }

        return body;
    }


}
