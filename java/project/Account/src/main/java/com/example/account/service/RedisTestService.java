package com.example.account.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class RedisTestService {
    private final RedissonClient redissonClient;

    // redisson에서 기본적으로 제공하는 lock 기능. 열쇠얻는것
    public String getLock() {
        // sampleLock이름의 lock을 가져옴
        RLock lock = redissonClient.getLock("sampleLock");

        // 아무도 이 이름을 lock으로 가져가지 않았기 때문에 try로 lock을 시도
        // 위에 가져온 lock을 try로 시도
        try {
            boolean isLock = lock.tryLock(1, 5, TimeUnit.SECONDS);
            if (!isLock) { // lock 획득 실패시
                log.error("======Lock acquisition failed======");
                return "Lock failed";
            }
        } catch (Exception e) {
            log.error("Redis lock failed");
        }// 최대 1초동안 기다리면서 lock을 찾아봄. lock 획득하면 5초동안 갖고있다가 풀어주는것
        // 명시적으로 lock.unlick();하면 락이 풀림. 락이 안풀리면 무조건 5초동안 갖고있는 것.
        // lock을 다른애가 획득하려고 하면 5초동안 실패하게 될거임.
        return "Lock success";
    }
}
