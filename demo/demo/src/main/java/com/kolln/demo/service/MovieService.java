package com.kolln.demo.service;

import com.kolln.demo.model.MovieEntity;

import java.util.List;

public interface MovieService {
    int checkAvailability(Long id);
    MovieEntity getMoviesByGender(Long id);
    MovieEntity getMoviesByStar(Long id);
    MovieEntity getMoviesByDirector(Long id);

    List<String> getAllGenres();
}
