package com.example.account;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class AccountDtoTest {

    @Test
    void accountDto() {
        // given
        //when
        //then

//        AccountDto accountDto = new AccountDto();
//        accountDto.setAccountNumber("accountNumber");
//        accountDto.setNickname("summer");
        // @AllArgsConstructor가 있으므로
        AccountDto accountDto = new AccountDto(
                "accountNumber",
                "summer",
                LocalDateTime.now()
        );



        System.out.println(accountDto.getAccountNumber());
        System.out.println(accountDto.toString());
        accountDto.getAccountNumber();

    }

}