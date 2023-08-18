package com.kolln.demo.service;

import com.kolln.demo.model.DirectorEntity;
import com.kolln.demo.model.GenreEntity;
import com.kolln.demo.model.MovieEntity;
import com.kolln.demo.model.dto.Genre;
import com.kolln.demo.model.dto.Movie;
import com.kolln.demo.repository.DirectorRepository;
import com.kolln.demo.repository.GenreRepository;
import com.kolln.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    private final DirectorRepository directorRepository;

    public MovieServiceImpl(MovieRepository movieRepository,
                            GenreRepository genreRepository,
                            DirectorRepository directorRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.directorRepository = directorRepository;
    }

    @Override
    public List<String> findMoviesByGenre_Id(Long id) {
        return movieRepository.getByGenres_Id(id).stream()
                .map(m -> m.getName())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findMoviesByStar_Id(Long id) {
        return null;
    }

    @Override
    public List<String> findMoviesByDirector_Id(Long id) {
        return movieRepository.getByDirector_Id(id).stream().map(m -> m.getName()).collect(Collectors.toList());
    }

    @Override
    public List<String> findAllGenres() {
        return genreRepository.findAll().stream()
                .map(g -> g.getName())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAvailableByNameAndFormat(String name, Long format) {
        return null;/*movieRepository.findAvailableByNameAndFormat_Id(name, format).stream()
                .map(f -> f.getName())
                .collect(Collectors.toList());*/
    }

    private Movie entityToMovieDto(MovieEntity entity) {
        Movie movieDto = new Movie();
        movieDto.setId(entity.getId());
        movieDto.setName(entity.getName());
        movieDto.setFormalRating(entity.getFormalRating());
        return movieDto;
    }

    private Genre entityToGenreDto(GenreEntity entity) {
        Genre genreDto = new Genre(entity.getId(), entity.getName());
        return genreDto;
    }
}
