package com.github.m111q.homework6.service;

import com.github.m111q.homework6.aspect.SendEmailAspect;
import com.github.m111q.homework6.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private List<Movie> movieList;

    public MovieService() {
        this.movieList = new ArrayList<>();
        movieList.add(new Movie("Titanic", 2020, "Adam Malysz"));
        movieList.add(new Movie("Manna", 1999, "Mariusz Pudzianowski"));
        movieList.add(new Movie("Kapitan Bomba", 2099, "Robert Kubica"));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    @SendEmailAspect()
    public boolean addMovieToList(Movie movie) {
        return movieList.add(movie);
    }
}
