package com.ozguryazilim.movie.repository;

import com.ozguryazilim.movie.model.CastModel;
import com.ozguryazilim.movie.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<MovieModel, Long> {
    Optional<MovieModel> findByName(String name);
    @Query(value = "SELECT m.*,c.*  FROM movies m " +
            "INNER JOIN movies_cast mc ON m.movie_id = mc.movie_model_movie_id " +
            "INNER JOIN casts c ON c.cast_id = mc.cast_cast_id " +
            "WHERE c.cast_name = ?1",nativeQuery = true
    )
    List<MovieModel> findByCast(String cast);
    Optional<MovieModel> findByType(String type);
}
