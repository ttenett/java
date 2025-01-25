package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.PayResult;

public class PayResponse {
    // 결제 결과
    PayResult payResult;

    // 결제 성공 금액
    Integer paidAmount;

    @Override // 인텔리제이에서 제공하는 toString은 객체 내용을 문자열로 만들어주는게 기본값.
    public String toString() {
        return "PayResponse{" +
                "payResult=" + payResult +
                ", paidAmount=" + paidAmount +
                '}';
    }

    public PayResponse(PayResult payResult, Integer paidAmount) {
        this.payResult = payResult;
        this.paidAmount = paidAmount;
    }

    public PayResult getPayResult() {
        return payResult;
    }

    public void setPayResult(PayResult payResult) {
        this.payResult = payResult;
    }

    public Integer getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Integer paidAmount) {
        this.paidAmount = paidAmount;
    }
}
