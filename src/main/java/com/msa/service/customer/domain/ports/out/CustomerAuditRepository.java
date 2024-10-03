package com.msa.service.customer.domain.ports.out;

import com.msa.service.customer.domain.models.CustomerAudit;

public interface CustomerAuditRepository {

    CustomerAudit saveCustomerAudit(CustomerAudit customerAudit);
}
