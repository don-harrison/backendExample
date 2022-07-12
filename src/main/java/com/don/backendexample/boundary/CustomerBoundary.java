package com.don.backendexample.boundary;
// java Program to Illustrate CustomerController File

import java.util.List;
// Importing required classes
import javax.validation.Valid;

import com.don.backendexample.entity.Customer;
import com.don.backendexample.controller.CustomerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Annotation
@RestController

// Class
public class CustomerBoundary {

    @Autowired private CustomerController customerService;

    // Save operation
    @PostMapping("/customers")
    public Customer[] saveCustomer(
            @Valid @RequestBody Customer[] customers)
    {
        for(Customer customer : customers){
            customerService.saveCustomer(customer);
        }
        return customers;
    }

    // Read operation
    @GetMapping("/customers")
    public List<Customer> fetchCustomerList()
    {
        return customerService.fetchCustomerList();
    }

    // Update operation
    @PutMapping("/customers/{id}")
    public Customer
    updateCustomer(@RequestBody Customer customer,
                     @PathVariable("id") Long customerId)
    {
        return customerService.updateCustomer(
                customer, customerId);
    }

    // Delete operation
    @DeleteMapping("/customers/{id}")
    public String deleteCustomerById(@PathVariable("id")
                                       Long customerId)
    {
        customerService.deleteCustomerById(
                customerId);
        return "Deleted Successfully";
    }
}
