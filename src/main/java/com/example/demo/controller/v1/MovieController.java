package com.example.demo.controller.v1;

import com.example.demo.dto.v1.MovieDTO;
import com.example.demo.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@Tag(name = "Movies API v1", description = "CRUD operations for Movies API version 1")
public class MovieController{

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Get all movies")
    @ApiResponse(responseCode = "200", description = "List of movies returned",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = MovieDTO.class))))
    @GetMapping
    public List<MovieDTO> getAllMovies() {
        return movieService.getAllMovies();
    }

    @Operation(summary = "Get a movie by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Movie found",
                    content = @Content(schema = @Schema(implementation = MovieDTO.class))),
            @ApiResponse(responseCode = "404", description = "Movie not found")
    })
    @GetMapping("/{id}")
    public MovieDTO getMovie(@PathVariable Long id) {
        MovieDTO movie = movieService.getMovieById(id);
        if (movie == null) {
            throw new RuntimeException("Movie not found"); // For simplicity
        }
        return movie;
    }

    @PostMapping
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Movie created",
                    content = @Content(schema = @Schema(implementation = MovieDTO.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })

    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Add a new movie")
    public MovieDTO postMovie(@RequestBody MovieDTO movie)
    {
        if (movieService.validMovie(movie)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid movie data");
        }
        return movieService.addMovie(movie);
    }
}
