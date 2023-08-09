package com.kolln.demo.service;

import com.kolln.demo.model.GenreEntity;
import com.kolln.demo.model.MovieEntity;

import java.util.List;

public interface MovieService {
    int checkAvailability(Long id);
    List<String> getMoviesByGenre(Long id);
    List<String> getMoviesByStar(Long id);
    List<String> getMoviesByDirector(Long id);

    List<String> getAllGenres();
    List<GenreEntity> getAllGenreEntities();
}
