package com.msa.service.customer.infrastructure.beans;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.customer.application.CustomerAuditServiceImpl;
import com.msa.service.customer.domain.ports.in.CustomerAuditService;
import com.msa.service.customer.domain.ports.out.CustomerAuditRepository;
import com.msa.service.customer.infrastructure.repository.JpaCustomerAuditRepository;
import com.msa.service.customer.infrastructure.repository.impl.CustomerAuditRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class CustomerAuditBeans {

    private final JpaCustomerAuditRepository jpaCustomerAuditRepository;
    private final ObjectMapper objectMapper;

    @Bean
    public CustomerAuditRepository customerAuditRepository() {
        return  new CustomerAuditRepositoryImpl(jpaCustomerAuditRepository,objectMapper);
    }

    @Bean
    public CustomerAuditService customerAuditService() {
        return new CustomerAuditServiceImpl(customerAuditRepository());
    }
}
