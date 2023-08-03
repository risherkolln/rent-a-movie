package com.kolln.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movies")
public class MovieEntity {
    @Id
    private Long id;
    private String name;
    private String genre;
    private Director director;
    private List<Actor> stars;
    private List<Writer> writers;
    private Double formalRating;
    private Double popularRating;
}
