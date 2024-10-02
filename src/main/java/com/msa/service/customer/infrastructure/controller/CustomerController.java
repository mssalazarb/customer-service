package com.msa.service.customer.infrastructure.controller;

import com.ms.customer.service.server.CustomerApi;
import com.ms.customer.service.server.models.CustomerDto;
import com.msa.service.customer.domain.ports.in.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@CrossOrigin
public class CustomerController implements CustomerApi {

    private final CustomerService customerService;

    @Override
    public ResponseEntity<CustomerDto> createCustomer(String xCmClientRequestId, String xCmClientUserAgent, CustomerDto customerDto){
        CustomerDto customer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CustomerDto> findCustomerById(String xCmClientRequestId, String xCmClientUserAgent, @RequestParam Long id){
        CustomerDto customerDto = customerService.findCustomerById(id);
        if(customerDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }
}
