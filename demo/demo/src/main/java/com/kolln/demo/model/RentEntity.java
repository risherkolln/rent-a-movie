package com.kolln.demo.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "rentals")
public class RentEntity {
    @Id
    private Long id;
/*    @ManyToOne
    private CustomerEntity customer;
    @ManyToOne
    private MovieCopyEntity movieCopy;*/
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    private Boolean returned;
}
