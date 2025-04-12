package com.manuela.backend.service;

import java.util.List;

import com.manuela.backend.dto.CreateMovieDTO;
import com.manuela.backend.dto.MovieDTO;

public interface MovieService {
    MovieDTO createMovie(CreateMovieDTO createMovieDTO);

    MovieDTO updateMovie(Long id, CreateMovieDTO createMovieDTO);

    void deleteMovie(Long id);

    MovieDTO getMovieById(Long id);

    List<MovieDTO> getAllMovies();
}
