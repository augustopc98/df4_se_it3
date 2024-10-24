package com.example.demo.service;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerDetails(Long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        return customer.orElse(null);
    }

    @Override
    public void updateCustomerAddress(Long customerId, String newAddress) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresent(c -> {
            c.setCustomerAddress(newAddress);
            customerRepository.save(c);
        });
    }

    @Override
    public void updateCustomerEmail(Long customerId, String newEmail) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        customer.ifPresent(c -> {
            c.setCustomerEmail(newEmail);
            customerRepository.save(c);
        });

    }
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}