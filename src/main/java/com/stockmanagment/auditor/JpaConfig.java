package com.stockmanagment.auditor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.stockmanagment.model.User;


@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAware", modifyOnCreate = false)
public class JpaConfig {
	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}
}