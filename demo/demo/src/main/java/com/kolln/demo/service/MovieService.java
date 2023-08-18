package com.kolln.demo.service;

import com.kolln.demo.model.dto.Genre;
import com.kolln.demo.model.dto.Movie;
import com.kolln.demo.model.dto.MovieCopy;
import com.kolln.demo.model.helper.MovieJson;

import java.util.List;

public interface MovieService {
    List<Movie> getAll();
    List<Genre> findAllGenres();
    List<Movie> findMoviesByGenre_Id(Long id);
    List<Movie> findMoviesByStar_Id(Long id);
    List<Movie> findMoviesByDirector_Id(Long id);
    List<MovieCopy> findAvailableMovieCopyByMovieAndFormat(Long movieId, Long formatId);
    void createMovie(MovieJson json);
}
