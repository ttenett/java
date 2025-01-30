package com.example.account.controller;

import com.example.account.dto.CancelBalance;
import com.example.account.dto.QueryTransactionResponse;
import com.example.account.dto.TransactionDto;
import com.example.account.dto.UseBalance;
import com.example.account.exception.AccountException;
import com.example.account.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 잔액 관련 컨트롤러
 * 1. 잔액 사용
 * 2. 잔액 사용 취소
 * 3. 거래 확인
 */
@Slf4j
@RestController // 스프링 빈으로 자동등록
@RequiredArgsConstructor
public class transactionController {
    private final TransactionService transactionService;

    @PostMapping("/transaction/use")
    public UseBalance.Response useBalance(
            // 최초 validation 하고,
            @Valid @RequestBody UseBalance.Request request
    ) {
        try {
            // userBalance안에서 처리함
            return UseBalance.Response.from(
                    transactionService.useBalance(request.getUserId(),
                            request.getAccountNumber(), request.getAmount())
            );
            // 최초 문제점(잔액 거래를 초과한다던가) e에 담아서 던져줌.
        } catch (AccountException e) {
            log.error("Failed to use balance. ");

            // 오류 발생시 실패 건 저장
            transactionService.saveFailedUserTransaction(
                    request.getAccountNumber(),
                    request.getAmount()
            );

            throw e;
        }
    }

    @PostMapping("/transaction/cancel")
    public CancelBalance.Response cancelBalance(
            // 최초 validation 하고,
            @Valid @RequestBody CancelBalance.Request request
    ) {
        try {
            // userBalance안에서 처리함
            return CancelBalance.Response.from(
                    transactionService.cancelBalance(request.getTransactionId(),
                            request.getAccountNumber(), request.getAmount())
            );
            // 최초 문제점(잔액 거래를 초과한다던가) e에 담아서 던져줌.
        } catch (AccountException e) {
            log.error("Failed to use balance. ");

            // 오류 발생시 실패 건 저장
            transactionService.saveFailedCancelTransaction(
                    request.getAccountNumber(),
                    request.getAmount()
            );

            throw e;
        }
    }

    @GetMapping("/transaction/{transactionId}")
    public QueryTransactionResponse queryTransaction(
            @PathVariable String transactionId) {
        return QueryTransactionResponse.from(
                transactionService.queryTransaction(transactionId)
        );
    }

}
