package com.alpha07.service;

import com.alpha07.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerID);

    void deleteCustomer(int customerID);
}
