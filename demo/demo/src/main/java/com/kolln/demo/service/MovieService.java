package com.kolln.demo.service;

import com.kolln.demo.model.GenreEntity;
import com.kolln.demo.model.MovieEntity;
import com.kolln.demo.model.dto.Genre;
import com.kolln.demo.model.dto.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findMoviesByGenre_Id(Long id);
    List<Movie> findMoviesByStar_Id(Long id);
    List<Movie> findMoviesByDirector_Id(Long id);
    List<Genre> findAllGenres();

    List<Movie> findAvailableByNameAndFormat(String name, Long format);
}
