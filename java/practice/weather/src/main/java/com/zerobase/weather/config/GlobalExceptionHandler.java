package com.zerobase.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
// 전역 예외가 모이도록
public class GlobalExceptionHandler {

    // 서버가 동작하다가 예외발생 시점이, 클라이언트에서 서버에 api 호출한 시점이라면 어떤걸반환할겨? (500반환)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Exception handleAllExceptions(){
        System.out.println("error from GlobalExceptionHandler");
        return new Exception();
    }


}
