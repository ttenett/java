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
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.channels.AcceptPendingException;
import java.time.LocalDateTime;

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

        // 제일 마지막에(가장 최근) 생성된 계좌를 가져와서 계좌번호보다 하나 더 큰 숫자 생성
        String newAccountNumber = accountRepository.findFirstByOrderByIdDesc()
                // 문자로 되어잇는 accountNumber를 숫자로 변환. 밑에 toString도 되고 ""도 됨
                .map(account -> (Integer.parseInt(account.getAccountNumber())) + 1 + "")
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


//        ); // 생성된 값을 AccountDto로 변환
//        return AccountDto.fromEntity(account);

        // 만약 한번밖에 안쓰는 엔티티라면 이렇게만 만들어서 닫아주기.
//        return AccountDto.fromEntity(
//                accountRepository.save(
//                Account.builder()
//                        .accountUser(accountUser)
//                        .accountStatus(IN_USE)
//                        .accountNumber(newAccountNumber)
//                        .balance(initialBalance)
//                        .registeredAt(LocalDateTime.now())
//                        .build()));
    }


    @Transactional
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get(); // 옵셔널로 값을 가져옴. 원래 옵셔널로는 값을 꺼내는건 추천하지 않아 경고뜸.
        // getAccount에 long값의 id를 받아와서 findById를 통해 id를 셀렉트. 가져온값을 get해서 넣어줌.
    }


}
