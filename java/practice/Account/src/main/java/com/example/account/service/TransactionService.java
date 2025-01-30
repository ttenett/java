package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountUser;
import com.example.account.domain.Transaction;
import com.example.account.dto.TransactionDto;
import com.example.account.exception.AccountException;
import com.example.account.repository.AccountRepository;
import com.example.account.repository.AccountUserRepository;
import com.example.account.repository.TransactionRepository;
import com.example.account.type.AccountStatus;
import com.example.account.type.ErrorCode;
import com.example.account.type.TransactionResultType;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import static com.example.account.type.TransactionResultType.*;
import static com.example.account.type.TransactionType.USE;

@Slf4j
@Service // 빈으로 등록
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    // 해당유저아이디로 유저정보 가져오기
    private final AccountUserRepository accountUserRepository;
    // account 찾으려면
    private final AccountRepository accountRepository;

    /**
     * 사용자 없는 경우, 계좌가 없는 경우, 사용자 아이디와 계좌 소유주가 다른 경우,
     *      계좌가 이미 해지 상태인 경우, 거래금액이 잔액보다 큰 경우,
     *      거래금액이 너무 작거나 큰 경우 실패 응답
     */
    @Transactional
    public TransactionDto useBalance(Long userId, String accountNumber,
                                     Long amount) {
        // user를 찾아줌
        AccountUser user = accountUserRepository.findById(userId)
                .orElseThrow(() -> new AccountException(ErrorCode.USER_NOT_FOUND));
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException(ErrorCode.ACCOUNT_NOT_FOUND));

        // 사용 validate
        validateBalance(user, account, amount);

        // validation 이후 정상처리 시 코드
        /** Long accountBalance = account.getBalance();
        // 묘한느낌이(?)든다 밸런스 변경하는 방식은 엔티티(setBalance) 안에 넣어주는거도 안전한 방법중 하나다.
        account.setBalance(accountBalance - amount); **/
        account.useBalance(amount); // amount만큼 useBalance를 깎아줌

        // account기반으로 신규 트랜잭션 저장
        return TransactionDto.fromEntity(saveAndGetTransaction(S, account, amount));
        // 두개의 업데이트와 인서트가 진행. 어카운트, 트랜잭션 리턴으로 두가지 인젝션
        // 트랜잭션으로 묶여있기 때문에 동시에 일어나거나 동시에 일어나지 않거나 함.
    }

    private void validateBalance(AccountUser user, Account account, Long amount) {
        // 사용자 아이디와 계좌 소유주가 다른 경우
        if(!Objects.equals(user.getId(), account.getAccountUser().getId())) {
            throw new AccountException(ErrorCode.USER_ACCOUNT_UN_MATCH);
        }
        // 사용자 없는 경우
        if(account.getAccountStatus() != AccountStatus.IN_USE) {
            throw new AccountException(ErrorCode.ACCOUNT_ALREADY_UNREGISTERED);
        }
        // 거래금액이 잔액보다 큰 경우
        if(account.getBalance() < amount) {
            throw new AccountException(ErrorCode.AMOUNT_EXCEED_BALANCE);
        }
    }

    @Transactional
    public void saveFailedUserTransaction(@NotBlank @Size(min = 10, max = 10) String accountNumber, @NotNull @Min(10) @Max(1000_000_000) Long amount) {
        // 거래로 남기는것을 포기
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountException(ErrorCode.ACCOUNT_NOT_FOUND));

        saveAndGetTransaction(F, account, amount);
    }

    private Transaction saveAndGetTransaction(
            TransactionResultType transactionResultType,
            Account account,
            Long amount) {
        return transactionRepository.save(
                Transaction.builder()
                        .transactionType(USE)
                        .transactionResultType(transactionResultType)
                        .account(account)
                        .amount(amount)
                        .balanceSnapshot(account.getBalance())
                        .transactionId(UUID.randomUUID().toString().replace("-", ""))
                        .transactedAt(LocalDateTime.now())
                        .build()
        );
    }
}
