package com.zerobase.weather.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="memo")
public class Memo {
    //primary key 명시
    @Id
    // auto increment 속성 부여, id값 없을시 자동으로 증가시키면서 배정.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;

}
