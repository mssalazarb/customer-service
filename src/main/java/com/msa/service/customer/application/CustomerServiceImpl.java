package com.msa.service.customer.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.customer.service.server.models.CustomerDto;
import com.msa.service.customer.domain.models.Customer;
import com.msa.service.customer.domain.ports.in.CustomerService;
import com.msa.service.customer.domain.ports.out.CustomerRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ObjectMapper objectMapper;

    @Override
    public CustomerDto createCustomer(CustomerDto customer) {
        Customer newCustomer = customerRepository.save(objectMapper.convertValue(customer,Customer.class));
        return objectMapper.convertValue(newCustomer,CustomerDto.class);
    }

    @Override
    public CustomerDto findCustomerById(Long id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        return objectMapper.convertValue(customer,CustomerDto.class);
    }
}
