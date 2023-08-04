package com.kolln.demo.service;

import com.kolln.demo.model.MovieEntity;
import com.kolln.demo.repository.GenreRepository;
import com.kolln.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public int checkAvailability(Long id) {
        return movieRepository.countById(id);
    }

    @Override
    public MovieEntity getMoviesByGender(Long id) {
        return null;
    }

    @Override
    public MovieEntity getMoviesByStar(Long id) {
        return null;
    }

    @Override
    public MovieEntity getMoviesByDirector(Long id) {
        return null;
    }

    @Override
    public List<String> getAllGenres() {
        return genreRepository.findAll().stream().map(g -> g.getName()).collect(Collectors.toList());
    }
}
