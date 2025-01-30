package com.example.account.domain;

import com.example.account.exception.AccountException;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder // 객체 생성 선호. 위 두개가 있어야 빌더들어간 객체 상속 받을때 권한 문제없이 가능. 위 다섯개를 엔티티나 Dto 클래스에 세트로 넣어줌.
@Entity  // 일종의 설정 클래스, 자바 객체처럼 보이지만 설정
@EntityListeners(AuditingEntityListener.class)
// @EntityListeners 얘를 사용하려면 어플리케이션 전체 설정에 넣어줘야 한다. config 패키지에 JpaAuditingConfiguration 클래스로 고
public class Account {
    @Id // Account라는 테이블 안에 Id를 PK를 지정해주겠다.
    @GeneratedValue
    private Long id;

    // 그냥 User라고 하면 DB 테이블쪽에 h2 시스템의 유저테이블과 충돌 할 수 있으므로 아래이름으로 함.
    @ManyToOne
    private AccountUser accountUser;
    private String accountNumber;

    // 0123 으로가 아닌 AccountStatus상의 enum값 실제 문자 그대로 DB테이블에 저장
    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;
    private Long balance;
    // enum은 데이터로 0123 으로 저장해두면 무슨값인지 구별어렵다. 그래서 @Enumerated(EnumType.STRING) 사용

    private LocalDateTime registeredAt;
    private LocalDateTime unRegisteredAt;

    // JPA에서 두개의 값은 직접 하기에 번거로운 부분. 그래서 자동으로 저장해주는 기능을 AccountUser에서 차용.
    @CreatedDate
    private LocalDate createdAt;
    // 업데이트 된 것은 자동으로 바꿔줌
    @LastModifiedDate
    private LocalDate updatedAt;

    // 중요한 데이터를 변경하는 로직은 객체 안에서 수행할 수 있도록
    public void useBalance(Long amount) {
        if (amount > balance) {
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
        balance -= amount;
    }

    public void cancelBalance(Long amount) {
        if (amount < 0) {
            throw new AccountException(ErrorCode.INVALID_REQUEST);
        }
        balance += amount;
    }




}
