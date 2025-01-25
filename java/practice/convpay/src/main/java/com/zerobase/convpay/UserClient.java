package com.zerobase.convpay;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequest;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;

public class UserClient {
    public static void main(String[] args) {
        // 컨페이서비스를 만들어서 결제시켜보는 역할
        // '사용자' -> 편결이 -> 머니

        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 편결이를 생성, 일을 시킬것. 결제시킬것
        // G25, 결제 1000원
        PayRequest payRequest = new PayRequest(ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        // System.out.println(payResponse); 모든 객체는 toString이 구현되어 있고, 기본 객체를 호출하면 toString으로 나옴.
        // 객체에 생성된 해시코드를 주게 되어있어 내용이 안나옴.
        System.out.println(payResponse);

        // G25, 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);

    }
}
