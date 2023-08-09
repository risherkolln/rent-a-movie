package com.kolln.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieCopy {
    private Long id;
    private String serialNumber;
    private Movie movie;
    private Format format;
}
