package com.msa.service.customer.infrastructure.repository;

import com.msa.service.customer.infrastructure.entity.CustomerAuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCustomerAuditRepository extends JpaRepository<CustomerAuditEntity,Long> {
}
