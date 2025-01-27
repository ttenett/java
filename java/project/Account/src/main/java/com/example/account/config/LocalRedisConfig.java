package com.example.account.config;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import redis.embedded.RedisServer;

@Configuration
public class LocalRedisConfig {
    @Value("${spring.data.redis.port}") // 레디스를 띄워줄 포트를 설정파일의 이 경로에 넣어줄것.
    private int redisPort; // 위의 경로로 가져와서 port에 담아주겠다.

    private RedisServer redisServer;

    @PostConstruct
    public void startRedis() { // 메소드 이름은 임의로 해도 무방하다.
        redisServer = new RedisServer(redisPort); // 객체를 만들어서
        redisServer.start(); // 시작시킴. 이 안에서 redis 하나를 띄워줌
    }

    @PreDestroy
    public void stopRedis() {
        if(redisServer != null) {
            redisServer.stop();
        }
    }
}
