package com.kolln.demo.controller;


import com.kolln.demo.model.GenreEntity;
import com.kolln.demo.service.MovieService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rent-a-movie/movies")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/genres")
    public String getAllGenres(Model model) {
        List<GenreEntity> genres = movieService.getAllGenreEntities();
     //   model.addAttribute("genres", genres);
        model.addAttribute("mensaje", "probando mensaje!");
        return "genres-list";
    }

    @GetMapping("/genres/{id}")
    public List<String> getMoviesByGenre(@PathVariable Long id) {
        List<String> movies = movieService.getMoviesByGenre(id);
        return movies;
    }

    @GetMapping("/directors/{id}")
    public List<String> getMoviesByDirector(@PathVariable Long id) {
        List<String> movies = movieService.getMoviesByDirector(id);
        return movies;
    }
}
