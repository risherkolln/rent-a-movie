package com.kolln.demo.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Movie {
    private Long id;
    private String name;
    private List<Genre> genres;
    private Director director;
    private List<Star> stars;
    private List<Writer> writers;
    private List<Rating> ratings;
    private int formalRating;
}
