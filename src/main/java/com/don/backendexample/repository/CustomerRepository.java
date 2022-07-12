package com.don.backendexample.repository;

import com.don.backendexample.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Annotation
@Repository
public interface CustomerRepository
        extends CrudRepository<Customer, Long> {
}