package com.kolln.demo.model.helper;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RentalJson {
    private Long customerId;
    private Long movieCopyId;
    private LocalDateTime rentDate;
    private LocalDateTime returnDate;
    private Boolean returned;
}
