package com.msa.service.customer.domain.ports.in;

import com.msa.service.customer.domain.models.Customer;
import com.msa.service.customer.domain.models.CustomerAudit;

public interface CustomerAuditService {

    CustomerAudit saveCustomerAudit(Customer customer, String action);
}
