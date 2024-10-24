package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id) {
        return customerService.getCustomerDetails(id);
    }

    @PutMapping("/{id}/address")
    public void updateAddress(@PathVariable Long id, @RequestParam String newAddress) {
        customerService.updateCustomerAddress(id, newAddress);
    }

    @PutMapping("/{id}/email")
    public void updateEmail(@PathVariable Long id, @RequestParam String newEmail) {
        customerService.updateCustomerEmail(id, newEmail);
    }
}