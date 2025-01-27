package com.example.account.service;

import com.example.account.domain.Account;
import com.example.account.domain.AccountStatus;
import com.example.account.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;

@Service // 서비스타입 빈으로 스프링에 자동등록하기 위해 어노테이션 붙여줌.
@RequiredArgsConstructor // 꼭 필요한 Argument가 들어간 생성자를 만들어줌. 내가 만들 빈에 다른 빈을 넣어주고 싶다면, final로 생성자 잡아주고, 어노테이션 사용
public class AccountService {
    private final AccountRepository accountRepository; // 이 값은 생성자가 아니면 담을수가 없게됨 나중에 변경 불가 (final 이니깐)
//    private  String noFinal; @RequiredArgsConstructor delombok 해보면 final 타입만 자동으로 생성자를 만들어준다.

    @Transactional
    // 파라미터로 계좌를 생성하도록 변경
    public void createAccount(Long userId, Long initialBalance) {

    } // 호출하려면 main 함수에서 호출할 수 있겠지만, 번거로움. controller에 호출할 수있는 엔드포인트 생성하기.

    @Transactional
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get(); // 옵셔널로 값을 가져옴. 원래 옵셔널로는 값을 꺼내는건 추천하지 않아 경고뜸.
        // getAccount에 long값의 id를 받아와서 findById를 통해 id를 셀렉트. 가져온값을 get해서 넣어줌.
    }


}
