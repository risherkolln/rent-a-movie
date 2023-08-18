package com.kolln.demo.service;

import java.util.List;

public interface MovieService {
    List<String> findMoviesByGenre_Id(Long id);
    List<String> findMoviesByStar_Id(Long id);
    List<String> findMoviesByDirector_Id(Long id);
    List<String> findAllGenres();

    List<String> findAvailableByNameAndFormat(String name, Long format);
}
