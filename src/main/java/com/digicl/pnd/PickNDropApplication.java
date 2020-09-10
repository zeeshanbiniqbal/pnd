package com.digicl.pnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.digicl.pnd.*"})
@EnableJpaRepositories(basePackages = {"com.digicl.pnd.repository"})
@EntityScan(basePackages = {"com.digicl.pnd.model"})
@EnableConfigurationProperties
@EnableCaching
public class PickNDropApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickNDropApplication.class, args);
	}

}
