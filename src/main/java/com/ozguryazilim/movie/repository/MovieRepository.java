package com.ozguryazilim.movie.repository;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.ozguryazilim.movie.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
}
