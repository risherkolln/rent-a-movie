package com.kolln.demo.controller;

import com.kolln.demo.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rent-a-movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/genres")
    public List<String> getAllGenres() {
        List<String> genres = movieService.getAllGenres();
        return genres;
    }

    @GetMapping("/genres/{id}")
    public List<String> getMoviesByGenre(@PathVariable Long id) {
        List<String> movies = movieService.getMoviesByGenre(id);
        return movies;
    }
}
