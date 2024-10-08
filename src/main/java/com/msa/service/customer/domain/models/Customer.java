package com.msa.service.customer.domain.models;

import com.msa.service.customer.domain.enums.GenreEnum;
import lombok.Data;

@Data
public class Customer {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String identification;
    private String firstName;
    private String lastName;
    private GenreEnum genre;
}
