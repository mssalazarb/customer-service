package com.msa.service.customer.infrastructure.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.customer.application.CustomerServiceImpl;
import com.msa.service.customer.domain.ports.in.CustomerService;
import com.msa.service.customer.domain.ports.out.CustomerRepository;
import com.msa.service.customer.infrastructure.repository.JpaCustomerRepository;
import com.msa.service.customer.infrastructure.repository.impl.CustomerRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CustomerBeans {

    private final JpaCustomerRepository jpaCustomerRepository;
    private final ObjectMapper objectMapper;

    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryImpl(jpaCustomerRepository, objectMapper);
    }

    @Bean
    public CustomerService customerService(){
        return new CustomerServiceImpl(customerRepository(), objectMapper);
    }

}
