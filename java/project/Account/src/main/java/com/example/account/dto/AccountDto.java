package com.example.account.dto;

import com.example.account.domain.Account;
import lombok.*;

import java.time.LocalDateTime;

// 5개 어노테이션 세트
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    // 응답에 필요한 데이터. Account, AccountController보면서 만듬
    private Long userId;
    private String accountNumber;
    private Long balance;

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    // Controller와 Service간에 응답을 주고받음.

    // 이런 생성자를 쓰는것도 괜찮겠지만, 이 dto는 엔티티를 통해서 만들어지는경우가 가장많다.
    // 그래서 fromEntity를 가지고 Dto가 변환을 할 수 있게 static한 메서드를 만들어주는게 생성할때 가독성,안정성좋다.
    public AccountDto(Long userId) {
        this.userId = userId;
    }

    // 이런 특정 타입에서 특정 타입으로 바꿔줄때 자주 사용하는 방법
    // fromEntity로 sttic 생성자 만듦
    public static AccountDto fromEntity(Account account) {
        return AccountDto.builder()
                .userId(account.getAccountUser().getId())
                .accountNumber(account.getAccountNumber())
                .balance(account.getBalance())
                .registeredAt(account.getRegisteredAt())
                .unRegisteredAt(account.getUnRegisteredAt())
                .build();
    }
}
