package br.com.ds.security;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Douglas Souza on 24/04/2019
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EntityScan({"br.com.ds.core.userconfig.model", "br.com.ds.core.userconfig.util"})
@ComponentScan("br.com.ds")
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@Bean
	public Module datatypeHibernateModule5() {
		return new Hibernate5Module();
	}
}
