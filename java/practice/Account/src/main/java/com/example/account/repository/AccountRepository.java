package com.example.account.repository;

import com.example.account.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // 맨 첫번째값 역순. 값이 있을수도있고 없을수도 있어서 optional
    // 인터페이스라서 구현부분은 따로 만들지 않음.
    Optional<Account> findFirstByOrderByIdDesc();
}
