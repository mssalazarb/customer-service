package com.msa.service.customer.infrastructure.entity;

import com.msa.service.customer.domain.enums.GenreEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="customers")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ctr_id", nullable = false)
    private Long id;

    @Column(name = "ctr_dni", nullable = false, unique = true)
    //@Column(name = "ctr_dni", nullable = false)
    private String identification;

    @Column(name = "ctr_f_name", nullable = false)
    private String firstName;

    @Column(name = "ctr_l_name", nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "ctr_genre", nullable = false)
    private GenreEnum genre;

}
