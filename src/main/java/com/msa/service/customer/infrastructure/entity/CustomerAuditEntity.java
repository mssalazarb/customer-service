package com.msa.service.customer.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="customer_audit")
public class CustomerAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "action")
    private String action;

    @Column(name = "local_date_time")
    private LocalDateTime timestamp;

}
