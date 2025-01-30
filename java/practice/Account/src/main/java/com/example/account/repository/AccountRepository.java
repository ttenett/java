package com.example.account.repository;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // 맨 첫번째값 역순. 값이 있을수도있고 없을수도 있어서 optional
    // 인터페이스라서 구현부분은 따로 만들지 않음.
    Optional<Account> findFirstByOrderByIdDesc();

    // (단순히 카운트만 하기때문에) 인티저로 응답을 주는 메서드
    Integer countByAccountUser(AccountUser accountUser);

    Optional<Account> findByAccountNumber(String accountNumber);
}
