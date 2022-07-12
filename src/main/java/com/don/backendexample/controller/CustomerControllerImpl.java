// Java Program to Demonstrate CustomerServiceImpl.java
// File
package com.don.backendexample.controller;

import java.util.List;
import java.util.Objects;

import com.don.backendexample.entity.Customer;
import com.don.backendexample.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerControllerImpl
        implements CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    // Save operation
    @Override
    public Customer saveCustomer(Customer customer)
    {
        return customerRepository.save(customer);
    }

    // Read operation
    @Override public List<Customer> fetchCustomerList()
    {
        return (List<Customer>)
                customerRepository.findAll();
    }

    // Update operation
    @Override
    public Customer
    updateCustomer(Customer customer,
                     Long customerId)
    {
        Customer depDB
                = customerRepository.findById(customerId)
                .get();

        if (Objects.nonNull(customer.getCustomerName())
                && !"".equalsIgnoreCase(
                customer.getCustomerName())) {
            depDB.setCustomerName(
                    customer.getCustomerName());
        }

        if (Objects.nonNull(
                customer.getCustomerAddress())
                && !"".equalsIgnoreCase(
                customer.getCustomerAddress())) {
            depDB.setCustomerAddress(
                    customer.getCustomerAddress());
        }

        if (Objects.nonNull(
                customer.getCustomerEmail())
                && !"".equalsIgnoreCase(
                customer.getCustomerEmail())) {
            depDB.setCustomerAddress(
                    customer.getCustomerEmail());
        }
        return customerRepository.save(depDB);
    }

    // Delete operation
    @Override
    public void deleteCustomerById(Long customerId)
    {
        customerRepository.deleteById(customerId);
    }
}
