package com.github.m111q.homework6.api;

import com.github.m111q.homework6.model.Movie;
import com.github.m111q.homework6.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieApi {

    private MovieService movieService;

    @Autowired
    public MovieApi(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<>(movieService.getMovieList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        boolean result = movieService.addMovieToList(movie);
        if (result) {
            return new ResponseEntity(HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
