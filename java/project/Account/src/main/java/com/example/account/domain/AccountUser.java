package com.example.account.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@EntityListeners(AuditingEntityListener.class)
public class AccountUser {
    // 각 테이블간의 기본적인 pk를 공통적으로 가져감. id로 검색하니까
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    // 모든 테이블이 공통적으로 갖고있으면 좋다. 테이블의 메타정보.
    @CreatedDate
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDate updatedAt;

}
