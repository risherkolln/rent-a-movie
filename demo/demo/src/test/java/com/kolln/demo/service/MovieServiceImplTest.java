package com.kolln.demo.service;

import com.kolln.demo.model.GenreEntity;
import com.kolln.demo.model.MovieEntity;
import com.kolln.demo.repository.DirectorRepository;
import com.kolln.demo.repository.GenreRepository;
import com.kolln.demo.repository.MovieRepository;
import com.kolln.demo.repository.StarRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;
    @Mock
    private GenreRepository genreRepository;
    @Mock
    private DirectorRepository directorRepository;
    @Mock
    private StarRepository starRepository;
    private MovieService service;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        service = new MovieServiceImpl(movieRepository,
                genreRepository,
                directorRepository,
                starRepository);
    }

    @Test
    public void getAll() {
        List<MovieEntity> movieList = new ArrayList<>();
        movieList.add(new MovieEntity());
        movieList.add(new MovieEntity());
        movieList.add(new MovieEntity());

        Mockito.when(movieRepository.findAll()).thenReturn(movieList);

        Assert.assertEquals(service.getAll().size(), 3);
    }

    @Test
    public void findMoviesByGenre_Id() {
        MovieEntity entity = new MovieEntity();
        entity.setId(1L);
        entity.setName("movie");
        List<GenreEntity> genreList = new ArrayList<>();
        GenreEntity genre = new GenreEntity();
        genre.setId(5L);
        genreList.add(genre);
        entity.setGenres(genreList);

        Mockito.when(movieRepository.findById(5L)).thenReturn(Optional.of(entity));

        Assert.assertEquals(Optional.ofNullable(service.findMoviesByGenre_Id(5L).get(0).getGenres().get(0).getId()), 5);
    }

    @Test
    public void findMoviesByStar_Id() {
    }

    @Test
    public void findMoviesByDirector_Id() {
    }

    @Test
    public void findAllGenres() {
    }

    @Test
    public void findAvailableMovieCopyByMovieAndFormat() {
    }

    @Test
    public void createMovie() {
    }
}