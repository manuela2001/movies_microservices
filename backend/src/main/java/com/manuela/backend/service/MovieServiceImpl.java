package com.manuela.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.manuela.backend.dto.CreateMovieDTO;
import com.manuela.backend.dto.MovieDTO;
import com.manuela.backend.entity.MovieEntity;
import com.manuela.backend.exception.AlreadyExistsException;
import com.manuela.backend.exception.NotFoundException;
import com.manuela.backend.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
        private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO createMovie(CreateMovieDTO createMovieDTO) {
        if (movieRepository.existsByName(createMovieDTO.name())) {
            throw new AlreadyExistsException("Movie already exists with name: " + createMovieDTO.name());
        }

        MovieEntity movieEntity = new MovieEntity();
        movieEntity.setName(createMovieDTO.name());
        movieEntity.setGenre(createMovieDTO.genre());
        movieEntity.setDuration(createMovieDTO.duration());

        movieEntity = movieRepository.save(movieEntity);
        return new MovieDTO(movieEntity.getId(), movieEntity.getName(), movieEntity.getGenre(), movieEntity.getDuration());
    }

    @Override
    public MovieDTO updateMovie(Long id, CreateMovieDTO createMovieDTO) {
        MovieEntity movieEntity = movieRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Movie not found with id: " + id));

        if (movieRepository.existsByName(createMovieDTO.name()) && !movieEntity.getName().equals(createMovieDTO.name())) {
            throw new AlreadyExistsException("Movie already exists with name: " + createMovieDTO.name());
        }

        movieEntity.setName(createMovieDTO.name());
        movieEntity.setGenre(createMovieDTO.genre());
        movieEntity.setDuration(createMovieDTO.duration());

        movieEntity = movieRepository.save(movieEntity);
        return new MovieDTO(movieEntity.getId(), movieEntity.getName(), movieEntity.getGenre(), movieEntity.getDuration());
    }

    @Override
    public void deleteMovie(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Movie not found with id: " + id));

        movieRepository.delete(movieEntity);
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        MovieEntity movieEntity = movieRepository.findById(id)
        .orElseThrow(() -> new NotFoundException("Movie not found with id: " + id));

        return new MovieDTO(movieEntity.getId(), movieEntity.getName(), movieEntity.getGenre(), movieEntity.getDuration());
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieEntity> movieEntities = movieRepository.findAll();
        return movieEntities.stream()
                .map(movieEntity -> new MovieDTO(movieEntity.getId(), movieEntity.getName(), movieEntity.getGenre(), movieEntity.getDuration()))
                .toList();
    }

}
