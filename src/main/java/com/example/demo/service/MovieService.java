package com.example.demo.service;

import com.example.demo.dto.v1.MovieDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MovieService {

    private final List<MovieDTO> movies = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public MovieService() {
        // Pre-populate with some movies
        movies.add(new MovieDTO(idGenerator.getAndIncrement(), "Inception", "Christopher Nolan", 2010));
        movies.add(new MovieDTO(idGenerator.getAndIncrement(), "The Matrix", "Lana Wachowski, Lilly Wachowski", 1999));
        movies.add(new MovieDTO(idGenerator.getAndIncrement(), "Interstellar", "Christopher Nolan", 2014));
        movies.add(new MovieDTO(idGenerator.getAndIncrement(), "The Godfather", "Francis Ford Coppola", 1972));
    }

    public List<MovieDTO> getAllMovies() {
        return movies;
    }

    public MovieDTO getMovieById(Long id) {
        return movies.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public MovieDTO addMovie(MovieDTO movie) {
        movie.setId(idGenerator.getAndIncrement());
        movies.add(movie);
        return movie;
    }

    public boolean validMovie(MovieDTO movie) {
        return movie.getTitle() != null && movie.getDirector() != null && movie.getYear() > 0;
    }
}
