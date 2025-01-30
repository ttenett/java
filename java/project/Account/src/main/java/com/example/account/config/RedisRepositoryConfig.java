package com.example.account.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisRepositoryConfig {
    @Value("${spring.data.redis.host}")
    private String redisHost;

    @Value("${spring.data.redis.port}")
    private int redisPort;

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + redisHost + ":" + redisPort);

        return Redisson.create(config);
        // 우리가 어떤 다른 서비스나 컨트롤러에서 레디스클라이언트 주입하게되면 여기서 생성된 레디스클라이언트가
        // 딱한번 거기로 끌려가서 일하게됨.
    }
}
