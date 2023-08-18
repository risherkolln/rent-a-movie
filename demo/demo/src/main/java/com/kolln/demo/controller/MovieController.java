package com.kolln.demo.controller;

import com.kolln.demo.model.dto.Movie;
import com.kolln.demo.model.dto.MovieCopy;
import com.kolln.demo.model.helper.MovieJson;
import com.kolln.demo.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rent-a-movie/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/genres")
    @ResponseStatus(HttpStatus.OK)
    public String getAllGenres() {
        return movieService.findAllGenres().stream()
                .map(g -> g.getName())
                .collect(Collectors.joining(","));
    }

    @GetMapping("/genres/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getMoviesByGenre(@PathVariable Long id) {
        return movieService.findMoviesByGenre_Id(id);
    }

    @GetMapping("/directors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getMoviesByDirector(@PathVariable Long id) {
        return movieService.findMoviesByDirector_Id(id);
    }

    @GetMapping(value = "/{id}/available", params = "formatId")
    @ResponseStatus(HttpStatus.OK)
    public List<MovieCopy> findAvailableCopiesByFormat(@PathVariable Long movieId, @RequestParam Long formatId) {
        return movieService.findAvailableMovieCopyByMovieAndFormat(movieId, formatId);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createMovie(@RequestBody MovieJson movieJson) {
        movieService.createMovie(movieJson);
    }
}
