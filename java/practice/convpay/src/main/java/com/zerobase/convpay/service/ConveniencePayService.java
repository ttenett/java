package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayResult;

public class ConveniencePayService {   // 편결이
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    
    public
    PayResponse pay(PayRequest payRequest){
        MoneyUseResult moneyUseResult =
                moneyAdapter.use(payRequest.getPayAmount());// 머니어댑터의 use를 호출

        // fail fast

        // Method() { - 성공 밑 끝까지 내려오도록. 메서드 읽기 편하고,
        // 유지보수시 예외케이스 추가하더라도 일관성있는 성공케이스를 유지할 수 있다.

        // Exception case1
        // Exception case2
        // Exception case3
        // 성공케이스가 중간에 위치하게 되면, 메서드의 정상 케이스를 읽기가 까다롭다.
        // 그위에 예외케이스들이 중간에 추가되는 일들이 많음.
        // 그래서 예외케이스를 중간에 처리하고, 단하나의 성공케이스를 맨 마지막에 위치함.
        // Success Case(Only one)
        // }

        // 예외적인 케이스들이 중간에 언제 어떻게 발생할 지 모르기 때문에
        // fail fast 빨리 실패를 해버리자
        if(moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);

        }
        // Success Case
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());

        // 성공케이스와 실패케이스를 if else로 표현은 피하는 방식일 수 있다. 선호도나 호불호의 차이.
        // 요즘 일반적으로 많이 선호되는 방법은 fail test -> 여러 exception case/Success case 나뉘어 있음.
//        if(moneyUseResult == MoneyUseResult.USE_SUCCESS) {
//            return new PayResponse(PayResult.SUCCESS, 100);
//        } else {
//            return new PayResponse(PayResult.FAIL, 100);
//        }
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());

        if(moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        // Success Case
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,
                payCancelRequest.getPayCancelAmount());
    }
}
