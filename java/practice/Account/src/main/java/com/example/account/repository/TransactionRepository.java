package com.example.account.repository;

import com.example.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
    // 스프링 japRepository를 상속받는 인터페이스

}
