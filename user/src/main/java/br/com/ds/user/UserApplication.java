package br.com.ds.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableJpaRepositories({
		"br.com.ds.core.account.repository",
		"br.com.ds.core.role.repository",
		"br.com.ds.core.user.repository",
		"br.com.ds.core.userrole.repository"})
@EntityScan({
		"br.com.ds.core.account.model",
		"br.com.ds.core.role.model",
		"br.com.ds.core.user.model",
		"br.com.ds.core.userrole.model"})
@ComponentScan("br.com.ds")
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

}
