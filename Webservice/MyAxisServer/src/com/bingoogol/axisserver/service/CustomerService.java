package com.bingoogol.axisserver.service;

import com.bingoogol.axisserver.pojo.Customer;

public class CustomerService {

    public Customer getCustomerByName(String name) {
        Customer c = new Customer();
        c.setId(1);
        c.setName(name);
        c.setAge(24);
        return c;
    }
}