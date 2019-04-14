package br.com.ds.customer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer  {
    private String name;
    private String address;
    private String port;

    public Customer() {
        this.name = null;
        this.address = null;
    }

    public Customer(String name, String address, String port) {
        this.name = name;
        this.address = address;
        this.port = port;
    }
}
