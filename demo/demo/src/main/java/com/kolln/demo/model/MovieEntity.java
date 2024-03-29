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
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "movie_genres",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreEntity> genres;
    @ManyToOne
    @JoinColumn(name = "director_id")
    private DirectorEntity director;
    @ManyToMany
    @JoinTable(
            name = "movie_stars",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "star_id"))
    private List<StarEntity> stars;
    @ManyToMany
    @JoinTable(
            name = "movie_writers",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "writer_id"))
    private List<WriterEntity> writers;
    @ManyToMany
    @JoinTable(
            name = "movie_ratings",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "rating_id"))
    private List<RatingEntity> ratings;
    private int formalRating;
}
