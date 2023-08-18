package com.kolln.demo.controller;

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

    @GetMapping("/genres")
    public String getAllGenres() {
        return movieService.findAllGenres().stream().collect(Collectors.joining(","));
    }

    @GetMapping("/genres/{id}")
    public List<String> getMoviesByGenre(@PathVariable Long id) {
        return movieService.findMoviesByGenre_Id(id);
    }

    @GetMapping("/directors/{id}")
    public List<String> getMoviesByDirector(@PathVariable Long id) {
        return movieService.findMoviesByDirector_Id(id);
    }

    @GetMapping(params = {"name", "format"})
    public List<String> findAvailableByNameAndFormat(@RequestParam String name, @RequestParam Long format) {
        return movieService.findAvailableByNameAndFormat(name, format);
    }
}
