package com.msa.service.customer.domain.ports.in;

import com.ms.customer.service.server.models.CustomerDto;

public interface CustomerService {

    CustomerDto createCustomer(CustomerDto customer);

    CustomerDto findCustomerById(Long id);
}
