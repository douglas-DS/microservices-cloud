package br.com.ds.customer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/customer")
public class CustomerController {

    @GetMapping
    public Customer getCustomer() {
        return new Customer("Bruce Wayne", "BatCave", "PORT: 8080");
    }
}
