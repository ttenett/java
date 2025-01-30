package com.example.account.repository;

import com.example.account.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TransactionRepository
        extends JpaRepository<Transaction, Long> {
    // 스프링 japRepository를 상속받는 인터페이스

    Optional<Transaction> findByTransactionId(String transactionId);

}
