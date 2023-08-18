package com.kolln.demo.service;

import com.kolln.demo.model.FormatEntity;
import com.kolln.demo.model.GenreEntity;
import com.kolln.demo.model.MovieCopyEntity;
import com.kolln.demo.model.MovieEntity;
import com.kolln.demo.model.dto.Format;
import com.kolln.demo.model.dto.Genre;
import com.kolln.demo.model.dto.Movie;
import com.kolln.demo.model.dto.MovieCopy;
import com.kolln.demo.model.helper.MovieJson;
import com.kolln.demo.repository.DirectorRepository;
import com.kolln.demo.repository.GenreRepository;
import com.kolln.demo.repository.MovieRepository;
import com.kolln.demo.repository.StarRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final DirectorRepository directorRepository;
    private final StarRepository starRepository;

    public MovieServiceImpl(MovieRepository movieRepository,
                            GenreRepository genreRepository,
                            DirectorRepository directorRepository,
                            StarRepository starRepository) {
        this.genreRepository = genreRepository;
        this.movieRepository = movieRepository;
        this.directorRepository = directorRepository;
        this.starRepository = starRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll().stream()
                .map(this::entityToMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findMoviesByGenre_Id(Long id) {
        return movieRepository.getByGenresId(id).stream()
                .map(this::entityToMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Movie> findMoviesByStar_Id(Long id) {
        return null;
    }

    @Override
    public List<Movie> findMoviesByDirector_Id(Long id) {
        return movieRepository.getByDirector_Id(id).stream()
                .map(this::entityToMovieDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreRepository.findAll().stream()
                .map(this::entityToGenreDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MovieCopy> findAvailableMovieCopyByMovieAndFormat(Long movieId, Long formatId) {
        return null;
    }

    @Override
    public void createMovie(MovieJson json) {
        MovieEntity entity = new MovieEntity();

        entity.setName(json.getName());
        entity.setDirector(directorRepository.findById(json.getDirectorId())
                .orElseThrow(ResourceNotFoundException::new));
        entity.setGenres(genreRepository.findByIdIn(json.getGenres()));
        entity.setStars(starRepository.findByIdIn(json.getStars()));
        entity.setFormalRating(json.getFormalRating());

        movieRepository.save(entity);
    }

    private MovieCopy entityToMovieCopyDto(MovieCopyEntity entity) {
        MovieCopy movieCopyDto = new MovieCopy();
        movieCopyDto.setId(entity.getId());
        movieCopyDto.setSerialNumber(entity.getSerialNumber());
        movieCopyDto.setMovie(entityToMovieDto(entity.getMovie()));
        movieCopyDto.setFormat(entityToFormatDto(entity.getFormat()));
        return movieCopyDto;
    }

    private Format entityToFormatDto(FormatEntity entity) {
        Format formatDto = new Format();
        formatDto.setId(entity.getId());
        formatDto.setName(entity.getName());
        return formatDto;
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
