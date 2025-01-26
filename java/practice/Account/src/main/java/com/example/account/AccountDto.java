package com.example.account;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;


@Getter
@Setter
@ToString
//@NoArgsConstructor // 아무것도 없는 생성자 만들어줌
@AllArgsConstructor // 모든 프로퍼티를 갖고있는 생성자 만들어줌
@RequiredArgsConstructor // 필수값들을 받게 하는 생성자를 만들어주는 기능
@Data
@Slf4j
public class AccountDto {
    // 게터와 세터이용해서 접근하도록 프로퍼티는 프라이빗으로 두기.
    private String accountNumber;
    private String nickname;
    private LocalDateTime registeredAt;

    public void log() {
        log.error("error is occurred.");
    }

    // 게터세터 생성 >> 이런게 보일러 플레이트 코드. 규약에 따르는 코드.
    // -> 문제가 뭐냐면 새로 위에 또 프로퍼티 생성해도 게터세터 동일하게 생성해줘야함.
    // 이름바꿀때도 전부 일일이 가서 다 수정해줬어야함. 인텔리제이 발전해서 한꺼번에 rename 할순있지만 번거롭다. 이럴대 쓰는게 롬복
    // 클래스위에 게터세터 저거만 놔둬도 눈에 안보이는 게터세터들이 만들어진것임 대박스; 어케아냐면 테스트코드 만들어보면 됨.

}
