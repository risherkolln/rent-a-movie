package com.kolln.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ratings")
public class RatingEntity {
    @Id
    private Long id;
    @ManyToOne
    private MovieEntity movie;
    private int rating;
}
