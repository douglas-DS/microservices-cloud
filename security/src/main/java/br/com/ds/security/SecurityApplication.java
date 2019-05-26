package br.com.ds.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Douglas Souza on 24/04/2019
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableJpaRepositories({"br.com.ds.core.user.repository"})
@EntityScan({"br.com.ds.core.user.model", "br.com.ds.core.account.model", "br.com.ds.core.user.role.model"})
@ComponentScan("br.com.ds")
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}
}
