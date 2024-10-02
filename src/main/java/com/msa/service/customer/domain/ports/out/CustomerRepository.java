package com.msa.service.customer.domain.ports.out;

import com.msa.service.customer.domain.models.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findById(Long id);
}
