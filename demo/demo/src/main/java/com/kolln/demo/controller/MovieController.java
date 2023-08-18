package com.kolln.demo.controller;

import com.kolln.demo.model.dto.Movie;
import com.kolln.demo.model.dto.MovieCopy;
import com.kolln.demo.model.helper.MovieJson;
import com.kolln.demo.service.MovieService;
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
    public List<Movie> getAll() {
        return movieService.getAll();
    }

    @GetMapping("/genres")
    public String getAllGenres() {
        return movieService.findAllGenres().stream()
                .map(g -> g.getName())
                .collect(Collectors.joining(","));
    }

    @GetMapping("/genres/{id}")
    public List<Movie> getMoviesByGenre(@PathVariable Long id) {
        return movieService.findMoviesByGenre_Id(id);
    }

    @GetMapping("/directors/{id}")
    public List<Movie> getMoviesByDirector(@PathVariable Long id) {
        return movieService.findMoviesByDirector_Id(id);
    }

    @GetMapping(value = "/available", params = {"movieId", "formatId"})
    public List<MovieCopy> findAvailableCopiesByFormat(@RequestParam Long movieId, @RequestParam Long formatId) {
        return movieService.findAvailableMovieCopyByMovieAndFormat(movieId, formatId);
    }

    @PostMapping()
    public void createMovie(@RequestBody MovieJson movieJson) {
        movieService.createMovie(movieJson);
    }
}
