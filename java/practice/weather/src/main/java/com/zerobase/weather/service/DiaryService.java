package com.zerobase.weather.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DiaryService {

    @Value("${openweathermap-key}")
    private String apiKey;

    public void createDiary(LocalDate date,String text) {
        getWeaterString();

    }

    private String getWeaterString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;
        // 유효한 url인지 확인
        System.out.println(apiUrl);
        return "";
    }
}
