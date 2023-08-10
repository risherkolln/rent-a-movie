package com.kolln.demo.service;

import com.kolln.demo.model.DirectorEntity;
import com.kolln.demo.model.GenreEntity;
import com.kolln.demo.model.MovieEntity;
import com.kolln.demo.model.dto.Genre;
import com.kolln.demo.model.dto.Movie;
import com.kolln.demo.repository.GenericRepository;
import com.kolln.demo.repository.GenreRepository;
import com.kolln.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    private final GenericRepository<DirectorEntity> directorRepository;

    public MovieServiceImpl(MovieRepository movieRepository,
                            GenreRepository genreRepository,
                            GenericRepository<DirectorEntity> directorRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.directorRepository = directorRepository;
    }

    @Override
    public List<Movie> findMoviesByGenre_Id(Long id) {
        return movieRepository.getByGenres_Id(id).stream().map(m -> m.getName()).collect(Collectors.toList());
    }

    @Override
    public List<Movie> getMoviesByStar_Id(Long id) {
        return null;
    }

    @Override
    public List<Movie> getMoviesByDirector_Id(Long id) {
        return movieRepository.getByDirector_Id(id).stream().map(m -> m.getName()).collect(Collectors.toList());
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll().stream().map(g -> g.getName()).collect(Collectors.toList());
    }

    @Override
    public List<GenreEntity> getAllGenreEntities() {
        return genreRepository.findAll();
    }

    @Override
    public List<Movie> findAvailableByNameAndFormat(String name, Long format) {
        return movieRepository.findAvailableByNameAndFormat_Id(name, format);
    }
}
