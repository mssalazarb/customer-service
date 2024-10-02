package com.msa.service.customer.infrastructure.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.customer.domain.models.Customer;
import com.msa.service.customer.domain.ports.out.CustomerRepository;
import com.msa.service.customer.infrastructure.entity.CustomerEntity;
import com.msa.service.customer.infrastructure.repository.JpaCustomerRepository;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class CustomerRepositoryImpl  implements CustomerRepository {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final ObjectMapper objectMapper;

    @Override
    public Customer save(Customer customer) {
       CustomerEntity customerEntity = jpaCustomerRepository.save(objectMapper.convertValue(customer, CustomerEntity.class));
       return objectMapper.convertValue(customerEntity, Customer.class);
    }

    @Override
    public Optional<Customer> findById (Long id) {
       Optional<CustomerEntity> customerEntity = jpaCustomerRepository.findById(objectMapper.convertValue(id,Integer.class));
       Customer customer = objectMapper.convertValue(customerEntity.get(), Customer.class);
       return Optional.of(customer);
    }
}
