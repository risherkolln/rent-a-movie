package com.kolln.demo.service;

import com.kolln.demo.model.GenreEntity;
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
    public List<String> getMoviesByGenre(Long id) {
        return movieRepository.getByGenres_Id(id).stream().map(m -> m.getName()).collect(Collectors.toList());
    }

    @Override
    public List<String> getMoviesByStar(Long id) {
        return null;
    }

    @Override
    public List<String> getMoviesByDirector(Long id) {
        return movieRepository.getByDirector_Id(id).stream().map(m -> m.getName()).collect(Collectors.toList());
    }

    @Override
    public List<String> getAllGenres() {
        return genreRepository.findAll().stream().map(g -> g.getName()).collect(Collectors.toList());
    }

    @Override
    public List<GenreEntity> getAllGenreEntities() {
        return genreRepository.findAll();
    }
}
