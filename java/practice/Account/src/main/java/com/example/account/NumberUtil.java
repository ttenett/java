package com.example.account;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberUtil {
//    private NumberUtil() {
//    }

    // 유틸성 클래스. 객체는 껍데기일 뿐 실질적인건 메서드
    // 필요한걸 만들어놓고 쓰는 메서드. 이런 경우엔 객체를 따로 생성할 필요가 없음.
    // 이런 경우엔 생성자를 프라이빗으로 만듦. 생성자를 쓰지 못하게 막음.
    public static Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public static Integer minus(Integer a, Integer b) {
        return a - b;
    }
}
