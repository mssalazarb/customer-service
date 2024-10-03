package com.msa.service.customer.application;

import com.msa.service.customer.domain.models.Customer;
import com.msa.service.customer.domain.models.CustomerAudit;
import com.msa.service.customer.domain.ports.in.CustomerAuditService;
import com.msa.service.customer.domain.ports.out.CustomerAuditRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
public class CustomerAuditServiceImpl implements CustomerAuditService {

    private final CustomerAuditRepository customerAuditRepository;

    @Override
    public CustomerAudit saveCustomerAudit(Customer customer, String action) {
        CustomerAudit customerAudit = new CustomerAudit();
        customerAudit.setCustomerId(customer.getId());
        customerAudit.setUserName(customer.getFirstName() + " " + customer.getLastName());
        customerAudit.setAction(action);
        customerAudit.setTimestamp(LocalDateTime.now());
        return customerAuditRepository.saveCustomerAudit(customerAudit);
    }
}
