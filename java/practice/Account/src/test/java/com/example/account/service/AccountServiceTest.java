package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock // 2.리포지토리를 가짜로 목으로 만들어서
    private AccountRepository accountRepository;

    @InjectMocks // 3.accountRepository에 붙여줌(인젝션, 의존성주입처럼 생성)
    // 4.accountService에 가짜로만든 accountRepository를 서비스에 인젝트해줌.
    // 1.그런데 여기엔 accountRepository가 의존되어있음. 가짜로 만들어서 넣어줘야 함. -> 모키토 @Mock으로
    private AccountService accountService;

    // 5.@BeforeEach부분 삭제

    @Test
    @DisplayName("계좌 조회 성공")
    void testXXX() {
        // given
        given(accountRepository.findById(anyLong()))
                .willReturn(Optional.of(Account.builder()
                        .accountStatus(AccountStatus.UNREGISTERED)
                        .accountNumber("65789")
                        .build()));
        //when
        Account account = accountService.getAccount(4555L);

        //then
        assertEquals("65789", account.getAccountNumber());
        assertEquals(AccountStatus.UNREGISTERED, account.getAccountStatus());
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