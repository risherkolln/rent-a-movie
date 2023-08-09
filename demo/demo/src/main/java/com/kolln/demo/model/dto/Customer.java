package com.kolln.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private Long id;
    private String name;
    private String address;
    private Long dni;
}
