package com.alpha07.dao;

import com.alpha07.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int customerID);

    void delete(int customerID);
}
