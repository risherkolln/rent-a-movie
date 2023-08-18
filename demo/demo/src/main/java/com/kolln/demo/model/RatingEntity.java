package com.kolln.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ratings")
public class RatingEntity {
    @Id
    private Long id;
    @ManyToOne
    private MovieEntity movie;
    private int rating;
}
