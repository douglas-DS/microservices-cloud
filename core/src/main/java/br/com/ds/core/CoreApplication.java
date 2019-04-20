package br.com.ds.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CitadelApp {
    public static void main(String[] args) {
        SpringApplication.run(CitadelApp.class, args);
    }
}
