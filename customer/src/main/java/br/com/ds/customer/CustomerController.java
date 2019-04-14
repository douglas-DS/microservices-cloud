package br.com.ds.customer;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

    @GetMapping
    @HystrixCommand
    public Customer getCustomer() {
        return new Customer("Bruce Wayne", "BatCave", "PORT: 8080");
    }
}
