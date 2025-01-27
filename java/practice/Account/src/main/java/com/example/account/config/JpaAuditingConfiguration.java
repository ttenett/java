package com.example.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration // 컴포넌트의 일종. 자동으로 빈으로 등록이되는 타입이 됨
@EnableJpaAuditing // 이 클래스 자체가 어플리케이션이 뜰때 오토스캔이 되는 타입이 됨.
// -> db에 저장되거나 업데이트 될 때 어노테이션 붙은 것들은 자동으로 저장,업데이트 해주게 된다.
public class JpaAuditingConfiguration {
}
