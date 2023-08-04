package com.kolln.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "movies")
public class MovieEntity {
    @Id
    private Long id;
    private String name;
  /*  @ManyToMany
    private List<GenresEntity> genres;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private DirectorEntity director;
    @OneToMany
    private List<StarEntity> stars;
    @OneToMany
    private List<WritersEntity> writers;*/
    private int formalRating;
    private int popularRating;
}
