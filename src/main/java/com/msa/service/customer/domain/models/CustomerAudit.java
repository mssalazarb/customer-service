package com.msa.service.customer.domain.models;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@RequiredArgsConstructor
public class CustomerAudit implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long customerId;
    private String action;
    private String userName;
    private LocalDateTime timestamp;
}
