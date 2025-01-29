package com.example.account.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor // 생성자로 자동으로 만들어줌
public enum ErrorCode {
    USER_NOT_FOUND("사용자가 없습니다."),
    MAX_ACCOUNT_PER_USER_10("사용자 최대 계좌는 10개입니다.")
    ;

    //이렇게 넣는게 좋다(선호도) - enum에 설명을 넣을수있게됨. 이해하기도 편하다.
    private final String description;
    //바꾸는게 없으니 final
}
