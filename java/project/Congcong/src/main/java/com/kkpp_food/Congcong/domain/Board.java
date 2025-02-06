package com.kkpp_food.Congcong.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    // 식별자, 기본키 필드
    @Id
    // 키값 생성은 db 기반으로
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BO_NO;
    private String BO_TITLE;
    private String BO_CONTENT;
    private LocalDate BO_DATE;

    public Board(String BO_TITLE, String BO_CONTENT, LocalDate BO_DATE) {
        this.BO_TITLE = BO_TITLE;
        this.BO_CONTENT = BO_CONTENT;
        this.BO_DATE = BO_DATE;
    }
}
