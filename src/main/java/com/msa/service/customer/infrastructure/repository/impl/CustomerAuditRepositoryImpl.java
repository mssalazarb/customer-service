package com.msa.service.customer.infrastructure.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.msa.service.customer.domain.models.CustomerAudit;
import com.msa.service.customer.domain.ports.out.CustomerAuditRepository;
import com.msa.service.customer.infrastructure.entity.CustomerAuditEntity;
import com.msa.service.customer.infrastructure.repository.JpaCustomerAuditRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CustomerAuditRepositoryImpl implements CustomerAuditRepository {

    private final JpaCustomerAuditRepository jpaCustomerAuditRepository;
    private final ObjectMapper objectMapper;

    @Override
    public CustomerAudit saveCustomerAudit(CustomerAudit customerAudit) {
        CustomerAuditEntity entity = objectMapper.convertValue(customerAudit, CustomerAuditEntity.class);
        CustomerAuditEntity savedCustomerEntity = jpaCustomerAuditRepository.save(entity);
        return objectMapper.convertValue(savedCustomerEntity, CustomerAudit.class);
    }

}
