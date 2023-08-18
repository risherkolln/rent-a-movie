package com.kolln.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
    private Long id;
    private Movie movie;
    private int rating;
}
