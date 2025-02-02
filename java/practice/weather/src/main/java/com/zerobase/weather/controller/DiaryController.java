package com.zerobase.weather.controller;

import com.zerobase.weather.service.DiaryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class DiaryController {
    // 받은 값들을 서비스에 전달해야 함.
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    public

    // 날씨 일기를 저장
    @PostMapping("/create/diary") // 해당 패스에 요청을 보냈을 때
    // @RequestParam 요청을 보낼때 넣어주는 파라미터 어노테이션
    // @DateTimeFormat date는 여러 형식으로 나타낼 수 있음. 포맷을 하나로 날짜 형식 지정 어노테이션
    // @RequestBody 요청할 때 body에 일기값(String)을 넣겠음
    void createDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody String text){
        diaryService.createDiary(date, text);
    }
}
