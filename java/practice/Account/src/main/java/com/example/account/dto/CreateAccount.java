package com.example.account.dto;

import lombok.*;

import java.time.LocalDateTime;

public class CreateAccount { // controller에서 creatAccount 요청 클래스를 만듬
    // creatAccount 하위에 주의 해야 할 점 - static으로 만들어야 함.
    @Getter
    @Setter
    public static class Request {
        private Long userId;
        private Long initialBalance;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;  // 유저 id
        private Long accountNumber; // 계좌번호
        private LocalDateTime registeredAt; // 등록 일시

    }
}
