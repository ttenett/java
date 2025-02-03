package com.zerobase.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;

@Service
public class DiaryService {

    @Value("${openweathermap-key}")
    private String apiKey;

    public void createDiary(LocalDate date,String text) {
        // 세부기능 3가지 1. open weather map에서 날씨 데이터 가져오기
        // 아래에서 반환된 값 출력
        //System.out.println(getWeaterString());
        String weatherData = getWeaterString();

        // 받아온 날씨 json 파싱하기

        // 파싱된 데이터 + 일기 값 우리 db에 담기

    }

    private String getWeaterString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;

        // url 호출하고 결과값 받아오는 과정에서 오류 발생할 수 있으므로 try catch문 사용
        try {

            URL url = new URL(apiUrl);
            // apiUrl을 http 형식으로 연결시키는 커넥션으 만들어서 열었음.
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // get 요청 보냄
            connection.setRequestMethod("GET");
            // 요청을 보낸다음에 응답결과의 코드 받아오기 (http 상태코드)
            int responseCode = connection.getResponseCode();
            // 응답코드에 따라 오류메시지 or 실제 메시지/응답객체를 받아옴
            // br에 넣어서 (속도와 성능 향상)
            BufferedReader br;
            // 만약 200이면 정상,
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            }else { // 오류가 나면 오류 결과 호출
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }
            String inputLine;
            // response라는 스트링 빌더에 결과값을 쌓는다.
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();

            // response를 string화 해서 클래스에서 반환
            return response.toString();
        }catch (Exception e) {
            return "failed to get response";
        }
    }
}
