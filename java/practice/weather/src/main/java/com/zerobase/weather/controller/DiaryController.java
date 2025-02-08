package com.zerobase.weather.controller;

import com.zerobase.weather.domain.Diary;
import com.zerobase.weather.service.DiaryService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
public class DiaryController {
    // 받은 값들을 서비스에 전달해야 함.
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // 날씨 일기를 저장
    @PostMapping("/create/diary") // 해당 패스에 요청을 보냈을 때
    // @RequestParam 요청을 보낼때 넣어주는 파라미터 어노테이션
    // @DateTimeFormat date는 여러 형식으로 나타낼 수 있음. 포맷을 하나로 날짜 형식 지정 어노테이션
    // @RequestBody 요청할 때 body에 일기값(String)을 넣겠음
    void createDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody String text){
        diaryService.createDiary(date, text);
    }

    // 일기 조회할때는 날짜값 정도만 바디에 넣으면 됨
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date) {
        return diaryService.readDiary(date);
    }

    // 날짜 범위로 조회, 오늘로부터 과거 n일 계산 or 몇월 몇일부터 몇월 몇일까지 두개의 값 인풋받기
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    @PutMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date, @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    @DeleteMapping("delete/diary")
    void deleteDiary(@RequestParam @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate date) {
        // 특정 날짜의 흑역사를 지우기 가능
        diaryService.deleteDiary(date);
    }
}
