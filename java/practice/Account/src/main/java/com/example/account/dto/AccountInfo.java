package com.example.account.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountInfo {
    // account의 몇가지 특정정보만 뽑아서 사용자에게 응답을 줌,
    // Client와 Controller 어플리케이션 간에 주고받는 응답
    // 굳이 dto를 여러개로 만드는 이유? 전용 dto를 만들지 않으면 복잡한 상황이 생김.
    // 의도치 않은 동작으로 장애가 반드시 생기게 되었다는 경험담. 딱 그용도로만 쓰는 특화된 dto
    private String accountNumber;
    private Long balance;



}
