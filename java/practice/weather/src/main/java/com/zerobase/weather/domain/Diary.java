package com.zerobase.weather.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// jpa 쓸때는 항상 entity 붙이기
@Entity
// 안의 컬럼값들을 가져올거니까
@Getter
@Setter
// 빈 다이어리 먼저 만들고, 그 안에 값을 채우고 싶다
@NoArgsConstructor
// 그외 한번에 다이어리에 있는 모든 컬럼을 넣을때에는 AllArgsConstructor
public class Diary {
    @Id
    // 자동생성 가능하도록
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String weather;
    private String icon;
    private double temperature;
    private String text;
    private LocalDate date;
}
