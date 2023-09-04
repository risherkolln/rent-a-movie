package com.kolln.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "rentals")
public class RentEntity {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customer;
    @ManyToOne
    @JoinColumn(name = "movie_copy_id")
    private MovieCopyEntity movieCopy;
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    private Boolean returned;
}
