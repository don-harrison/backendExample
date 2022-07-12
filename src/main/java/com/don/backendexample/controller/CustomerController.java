package com.don.backendexample.controller;

// Importing required classes
import com.don.backendexample.entity.Customer;

import java.util.List;

// Interface
public interface CustomerController {

    // Save operation
    Customer saveCustomer(Customer customer);

    // Read operation
    List<Customer> fetchCustomerList();

    // Update operation
    Customer updateCustomer(Customer customer,
                                Long customerId);

    // Delete operation
    void deleteCustomerById(Long customerId);
}
