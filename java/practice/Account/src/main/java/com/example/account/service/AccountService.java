package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.dto.AccountDto;
import com.example.account.exception.AccountException;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.AccountUserRepository;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;
import java.time.LocalDateTime;
import java.util.Objects;

import static com.example.account.type.AccountStatus.IN_USE;

@Service // 서비스타입 빈으로 스프링에 자동등록하기 위해 어노테이션 붙여줌.
@RequiredArgsConstructor // 꼭 필요한 Argument가 들어간 생성자를 만들어줌. 내가 만들 빈에 다른 빈을 넣어주고 싶다면, final로 생성자 잡아주고, 어노테이션 사용
public class AccountService {
    private final AccountRepository accountRepository; // 이 값은 생성자가 아니면 담을수가 없게됨 나중에 변경 불가 (final 이니깐)
//    private  String noFinal; @RequiredArgsConstructor delombok 해보면 final 타입만 자동으로 생성자를 만들어준다.
    private final AccountUserRepository accountUserRepository;

    /**
     * 사용자가 있는지 조회
     * 계좌의 번호를 생성하고
     * 계좌를 저장하고, 그 정보를 넘긴다.
     */
    @Transactional
    // 파라미터로 계좌를 생성하도록 변경
    public AccountDto createAccount(Long userId, Long initialBalance) {
        // Accountuser 로 값을 받아오기 > 지역변수에 넘겨줌. 없으면 예외.
        AccountUser accountUser = accountUserRepository.findById(userId)
                // user가 없으면 예외를 날림 -> 에러를 날림.
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));

        // 이 사람이 소유하고 있는 계좌의 개수가 확인이 됨.
        // 사실 정상적인 로직안에서 굳이 이 안에 크게 자리잡을 필요는 없다. 또 다른 케이스들을 validation하다가 너무 비대해짐. 정상적 코드 읽기 어려워짐
        // >> 별도의 메서드로 추출하는게 좋다. 위에서 어카운트 찾고, 벨리데이트하고
        validateCreateAccount(accountUser);

        // 제일 마지막에(가장 최근) 생성된 계좌를 가져와서 계좌번호보다 하나 더 큰 숫자 생성
        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                .map(account -> (Integer.parseInt(account.getAccountNumber()) + 1 + ""))
                // account가 하나도 없었다면
                .orElse("1000000000");

        // 신규 계좌 저장
        return AccountDto.fromEntity(
                accountRepository.save(Account.builder()
                        .accountUser(accountUser)
                        .accountStatus(IN_USE)
                        .accountNumber(newAccountNumber)
                        .balance(initialBalance)
                        .registeredAt(LocalDateTime.now())
                        .build())
        );
    }

    // 어카운트 유저의 계좌수가 10개면 예외 발생시킴.
    private void validateCreateAccount(AccountUser accountUser) {
        // 방어적으로 하기 위해서는 == 10 보다 >= 10 이 낫다
        if(accountRepository.countByAccountUser(accountUser) >= 10 ) {
            throw new AccountException(ErrorCode.MAX_ACCOUNT_PER_USER_10);
        }
    }

    @Transactional
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get(); // 옵셔널로 값을 가져옴. 원래 옵셔널로는 값을 꺼내는건 추천하지 않아 경고뜸.
        // getAccount에 long값의 id를 받아와서 findById를 통해 id를 셀렉트. 가져온값을 get해서 넣어줌.
    }


    @Transactional
    public AccountDto deleteAccount(@NotNull @Min(1) Long userId, @NotBlank @Size(min = 10, max = 10) String accountNumber) {
        AccountUser accountUser = accountUserRepository.findById(userId)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException(ErrorCode.ACCOUNT_NOT_FOUND));

        validateDeleteAccount(accountUser, account);

        // 위2가지, 아래 3가지 밸리데이션 이후, 정상적으로 계좌를 해지할 수 있는 상태가 됨.
        account.setAccountStatus(AccountStatus.UNREGISTERED);
        account.setUnRegisteredAt(LocalDateTime.now());

        // test원활히 보이기 위해 save를 넣음. 추천하는 로직은 아님.
        accountRepository.save(account);

        return AccountDto.fromEntity(account);
    }

    // 위에서 userId, accountNumber가져와서 아래의 다양한 validation을 수행함
    private void validateDeleteAccount(AccountUser accountUser, Account account) {
        if(!Objects.equals(accountUser.getId(), account.getAccountUser().getId())) {
            throw new AccountException(ErrorCode.USER_ACCOUNT_UN_MATCH);
        }
        // 계좌가 이미
        if(account.getAccountStatus() == AccountStatus.UNREGISTERED) {
            throw new AccountException(ErrorCode.ACCOUNT_ALREADY_UNREGISTERED);
        }
        if(account.getBalance() > 0) {
            throw new AccountException(ErrorCode.BALANCE_NOT_EMPTY);
        }
    }
}
