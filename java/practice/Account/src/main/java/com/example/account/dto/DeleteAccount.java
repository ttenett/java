package com.example.account.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

public class DeleteAccount { // AccountController에서 deleteAccount 요청 클래스를 만듬
    // 하위에 주의 해야 할 점 - static으로 만들어야 함.
    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {
        // userId는 1과 같거나 크고, accountNumber는 10자리에 빈값이 없는값.
        @NotNull
        @Min(1) // userId가 0인 사람이 없다고 가정하고 1부터 달아줌.
        private Long userId;

        // 계좌번호를 받아야 함
        @NotBlank // not null보다 강력한
        @Size(min = 10, max = 10) // 문자열의 길이를 확인해줌
        private String accountNumber;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long userId;  // 유저 id
        private String accountNumber; // 계좌번호
        private LocalDateTime unRegisteredAt; // 등록 일시

        public static Response from(AccountDto accountDto) {
            // accountDto에서 가져옴.
            return Response.builder()
                    .userId(accountDto.getUserId())
                    .accountNumber(accountDto.getAccountNumber())
                    .unRegisteredAt(accountDto.getUnRegisteredAt())
                    .build();
        }

    }
}
