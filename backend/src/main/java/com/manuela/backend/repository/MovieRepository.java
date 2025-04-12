package com.manuela.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manuela.backend.entity.MovieEntity;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Long> {
    boolean existsByName(String name);    
}
