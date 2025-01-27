package com.example.account.controller;

import com.example.account.domain.Account;
import com.example.account.dto.CreateAccount;
import com.example.account.repository.AccountRepository;
import com.example.account.service.AccountService;
import com.example.account.service.RedisTestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // 빈으로 등록해달라고 스프링에게 얘기해줌
@RequiredArgsConstructor
public class AccountController {
    private final AccountRepository accountRepository;
    private final AccountService accountService;
    private final RedisTestService redisTestService;

    @PostMapping("/account")
    public CreateAccount.Response createAccount(
            @RequestBody @Valid CreateAccount.Request request
    ) {
        accountService.createAccount();
        return "success";
    }

    @GetMapping("/get-lock")
    public String getLock() {
        return redisTestService.getLock(); // getLock한 결과를 바로 리턴
    } // redistTestService의 getlock 호출, lock을 획득해올것임


    @GetMapping("/account/{id}")
    public Account getAccount(
            @PathVariable Long id) {
        return accountService.getAccount(id);
    } // url account 뒤의 숫자를 가지고 id로 담아서 getAccount 호출
    // AccountService에서 accountRepository 테이블에서 id로 셀렉트, 값을 응답
}
