package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.dto.AccountDto;
import com.example.account.exception.AccountException;
import com.example.account.repository.AccountUserRepository;
import com.example.account.type.AccountStatus;
import com.example.account.repository.AccountRepository;
import com.example.account.type.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountUserRepository accountUserRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    void createAccountSuccess() {
        // given
        AccountUser user = AccountUser.builder()
                .id(12L)
                .name("Pobi").build();
        given(accountUserRepository.findById(anyLong()))
                .willReturn(Optional.of(user));
        given(accountRepository.findFirstByOrderByIdDesc())
                .willReturn(Optional.of(Account.builder()
                                .accountNumber("1000000012").build()));
        given(accountRepository.save(any()))
                .willReturn(Account.builder()
                        .accountUser(user)
                        .accountNumber("1000000015").build());

        // save할때 확인 검증코드 - 12 다음 13이어야하는데 15를 입력해도 성공됨
        ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);

        //when
        AccountDto accountDto = accountService.createAccount(1L, 1000L);

        //then
        // 리파지토리가 1번 저장, 세이브할때 캡터와 저장한정보를 캡쳐할 것.
        verify(accountRepository, times(1)).save(captor.capture());
        assertEquals(12L, accountDto.getUserId());
        assertEquals("1000000013", captor.getValue().getAccountNumber());
    }

    @Test
    void createFirstAccount() {
        // given
        AccountUser user = AccountUser.builder()
                .id(15L)
                .name("Pobi").build();
        given(accountUserRepository.findById(anyLong()))
                .willReturn(Optional.of(user));
        given(accountRepository.findFirstByOrderByIdDesc()) // 여기서 리턴할때,
                .willReturn(Optional.empty()); // 아무 계좌도 없는 상황일 때
        given(accountRepository.save(any())) // 저장을 하게 되는 계좌는 임의의 값이 저장.
                .willReturn(Account.builder()
                        .accountUser(user)
                        .accountNumber("1000000015").build());

        // 실제로 저장되는 값은 captor에 들어가게 됨.
        ArgumentCaptor<Account> captor = ArgumentCaptor.forClass(Account.class);

        //when
        AccountDto accountDto = accountService.createAccount(1L, 1000L);

        //then
        // 리파지토리가 1번 저장, 세이브할때 캡터와 저장한정보를 캡쳐할 것.
        verify(accountRepository, times(1)).save(captor.capture());
        assertEquals(15L, accountDto.getUserId());
        assertEquals("1000000000", captor.getValue().getAccountNumber());
    }   // 응답하는 유저 기본값  "1000000000"

    @Test
    @DisplayName("해당 유저 없음 - 계좌 생성 실패")
    void createAccount_UserNotFound() {
        // given
        // 기존 코드내용 워킹들은 의미가 없다. FindById에서 내용없으니까 리셉션 터짐. 불필요한 부분 삭제
        given(accountUserRepository.findById(anyLong())) // fBI에서 결과로
                .willReturn(Optional.empty()); // 텅텅빈 옵션이 넘어오게되면

        //when
        // accountService에 createAccount를 하게되면 account exception이 발생하게 될 것임
        AccountException exception = assertThrows(AccountException.class, // 해당로직은 exception을 던질것이고
                () -> accountService.createAccount(1L, 1000L));


        //then
        // accountExcpetion의 결과가 userNot Found일 것이다 라고 검증
        assertEquals(ErrorCode.USER_NOT_FOUND, exception.getErrorCode()); // 에러코드를 UserNotFound를 갖고있을것이다.

    }

    // 계좌생성 10개이상일때 에러처리 > 유저어카운트를 통해서 > 어카운트리파지토리 조회
    // > 이 유저가 몇개나 갖고잇는지 확인
    @Test
    @DisplayName("유저 당 최대 계좌는 10개")
    void createAccount_maxAccountIs10() {
        // given
        AccountUser user = AccountUser.builder()
                .id(15L)
                .name("Pobi").build();
        given(accountUserRepository.findById(anyLong()))
                .willReturn(Optional.of(user));
        // 어카운트로 계좌의 개수 조회했을때, 응답으로 10을 줬을때
        given(accountRepository.countByAccountUser(any()))
                .willReturn(10);

        //when
        // 2. account  exception이 발생, 그 예외가 exception에 담아질것
        AccountException exception = assertThrows(AccountException.class,
                // 1. createAccount할 때
                () -> accountService.createAccount(1L, 1000L));


        //then
        // accountExcpetion의 결과가 MAX_ACCOUNT_PER_USER_10일 것이다 라고 검증
        assertEquals(ErrorCode.MAX_ACCOUNT_PER_USER_10, exception.getErrorCode());
    }

}