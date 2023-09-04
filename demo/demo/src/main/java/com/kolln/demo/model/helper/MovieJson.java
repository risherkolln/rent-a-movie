package com.kolln.demo.model.helper;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieJson {
    private String name;
    private List<Long> genres;
    private Long directorId;
    private List<Long> stars;
    private List<Long> writers;
    private int formalRating;
}
