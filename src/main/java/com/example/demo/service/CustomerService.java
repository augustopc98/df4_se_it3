package com.example.demo.service;

import com.example.demo.model.Customer;

public interface CustomerService {
    Customer getCustomerDetails(Long customerId);
    void updateCustomerAddress(Long customerId, String newAddress);
    void updateCustomerEmail(Long customerId, String newEmail);
    Customer createCustomer(Customer customer);  // New method to create customer
}