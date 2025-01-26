package com.example.account.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // 객체 생성 선호. 위 두개가 있어야 빌더들어간 객체 상속 받을때 권한 문제없이 가능. 위 다섯개를 엔티티나 Dto 클래스에 세트로 넣어줌.
@Entity  // 일종의 설정 클래스, 자바 객체처럼 보이지만 설정
public class Account {
    @Id // Account라는 테이블 안에 Id를 PK를 지정해주겠다.
    @GeneratedValue
    Long id;

    private String accountNumber;

    @Enumerated(EnumType.STRING) // enum값의 실제 문자열 그대로 Db에 저장함.
    private AccountStatus accountStatus;
    // enum은 데이터로 0123 으로 저장해두면 무슨값인지 구별어렵다. 그래서 @Enumerated(EnumType.STRING) 사용

}
