package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccountServiceTest {
    // private AccountService accountService = new AccountService(new AccountRepository());
    // 테스트하려면 account 서비스 생성자 필요. 근데 지금은 단순하지만 의존성이 많아지면 뇌절의 뇌절이 된다..
    // 테스트하기 너무 불편,, 이 accountService를 편하게 테스트할 수 있는 방법이 없으까 -> SprinBootTest
    @Autowired
    private AccountService accountService;

    @BeforeEach
    // 각각의 테스트하기 전 동작시켜주는 코드 >> 순차적으로 생성될때 찾을 수 있음
    // 아래에 id 둘다 2면, 첫번째는 1이아니라 실패하지만, 두번째 동작은 실행이 되고 성공됨.
    void init() {
        accountService.createAccount();
    }

    @Test
    @DisplayName("Test 이름 변경")
    void testGetAccount() {
        // 저장된 정보가 아직 없다. 하나를 저장해줌.순차 생성이기 때문에 accout가 id 1로 db에 생성
        // accountService.createAccount(); -beforeEach 로 생략
        // 생성한것을 불러오기. id 1 가져와서 accout 엔티티에 담긴 데이터 > createAccount에 있는대로 어카운트넘버 40000, INUSE
        Account account = accountService.getAccount(1L);

        assertEquals("40000", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }

    @Test
    void testGetAccount2() {
        Account account = accountService.getAccount(2L);

        assertEquals("40000", account.getAccountNumber());
        assertEquals(AccountStatus.IN_USE, account.getAccountStatus());
    }


}