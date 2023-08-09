package com.kolln.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Rent {
    private Long id;
    private Customer customer;
    private MovieCopy movieCopy;
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    private Boolean returned;
}
