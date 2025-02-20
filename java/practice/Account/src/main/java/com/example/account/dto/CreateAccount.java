package com.example.account.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

public class CreateAccount { // controller에서 creatAccount 요청 클래스를 만듬
    // creatAccount 하위에 주의 해야 할 점 - static으로 만들어야 함.
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        @NotNull
        @Min(1) // userId가 0인 사람이 없다고 가정하고 1부터 달아줌.
        private Long userId;

        @NotNull
        @Min(0) // Delete 하기 위해 처음 계좌 생성시 0원 으로 임시로 변경. (현재는 잔액조회기능 없어서)
        private Long initialBalance;

    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;  // 유저 id
        private String accountNumber; // 계좌번호
        private LocalDateTime registeredAt; // 등록 일시

        public static Response from(AccountDto accountDto) {
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .registeredAt(accountDto.getRegisteredAt())
                    .build();
        }

    }
}
