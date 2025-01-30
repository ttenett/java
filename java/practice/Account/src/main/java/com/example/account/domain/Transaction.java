package com.example.account.domain;

import com.example.account.type.AccountStatus;
import com.example.account.type.TransactionResultType;
import com.example.account.type.TransactionType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class) // 자동으로 생성시간,업데이트시간 등록
public class Transaction {
    // Account와 유사한점이 많아 붙여넣고 수정
    @Id
    @GeneratedValue
    private Long id; // pk 그대로 쓰면 보안상, 비지니스 적으로도 거래횟수노출해서 안됨

    @Enumerated(EnumType.STRING) // enum은 기본적으로 0123으로 저장됨. Enum값 그대로 저장되도록 해줌
    private TransactionType transactionType;
    @Enumerated(EnumType.STRING)
    private TransactionResultType transactionResultType;

    @ManyToOne
    // 이 계좌에 transcaction n개가 특정어카운트 1개에 연결
    private Account account;
    private Long amount; // 거래금액
    private Long balanceSnapshot; // 현재 밸런스의 스냅샷

    private String transactionId; // 거래의 고유 아이디
    private LocalDateTime transactedAt; // 거래시간 스냅샷정도.

    @CreatedDate
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDate updatedAt; // 다른용도로 변경시 이 트랜잭션 시간이 영향받음.
}
