package com.fastcampus.projectboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

@EnableJpaAuditing
@Configuration
public class JpaConfig {

    // Spring Data JPA 감사 관련 정보를 제공
    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.of("dohyeon");    // TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때 수정 필요
    }
}

/* 자세한 설명:
* @EnableJpaAuditing:
* @EnableJpaAuditing 어노테이션은 Spring Data JPA의 감사(감시) 기능을 활성화하는 데 사용됩니다.
* 이 어노테이션을 사용하면 JPA 엔티티 클래스에
* @CreatedDate, @LastModifiedDate, @CreatedBy, @LastModifiedBy와 같은 감사 관련 어노테이션을 사용할 수 있습니다.

* @Configuration:
* 이 클래스는 Spring의 구성(Configuration) 클래스임을 나타내는 어노테이션입니다.
* Spring 애플리케이션 컨텍스트에 빈(bean)을 정의하고 설정을 구성하는 데 사용됩니다.

* @Bean:
* auditorAware() 메서드는 Spring 빈으로 등록되며, 이 메서드가 반환하는 객체가 감사(Auditing)를 수행할 때 사용됩니다.

* AuditorAware<String>:
* AuditorAware 인터페이스의 제네릭 형식을 String으로 지정합니다.
* 이 인터페이스는 감사 관련 정보를 제공하는데 사용됩니다.

* () -> Optional.of("dohyeon"):
* AuditorAware 인터페이스의 구현체를 정의합니다.
* 람다식을 사용하여 현재 사용자의 이름을 "dohyeon"으로 지정하고 Optional으로 래핑합니다.
* 이것은 현재 사용자의 이름을 감사 정보로 사용하겠다는 의미입니다.

* // TODO: 스프링 시큐리티로 인증 기능을 붙이게 될 때 수정 필요:
* 주석으로 표시된 부분은 나중에 Spring Security를 사용하여 실제 인증 정보를 추출할 때 수정해야 할 부분입니다.
* 현재는 간단히 "dohyeon"을 하드코딩한 상태이지만, 실제로는 로그인한 사용자의 이름을 추출하거나 인증 정보를 활용해야 합니다.

* 이 설정은 Spring Data JPA를 사용하여 감사 정보를 기록하고 추적하는 데 도움이 됩니다.
* 주석에도 나와 있듯이, 보다 실제적인 사용을 위해 Spring Security와 통합하여 사용자 정보를 제공할 수 있도록 수정하는 것이 좋습니다.
* */
