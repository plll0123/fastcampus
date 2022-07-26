package com.toyproject;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

import static java.util.Optional.of;
import static java.util.UUID.randomUUID;

@EnableJpaAuditing
@SpringBootApplication
public class FastcampusApplication {

	HttpSession session;

	public static void main(String[] args) {
		SpringApplication.run(FastcampusApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return () -> of(randomUUID().toString());
	}

	@PersistenceContext
	public EntityManager em;

	@Bean
	public JPAQueryFactory jpaQueryFactory() {
		return new JPAQueryFactory(em);
	}
}
