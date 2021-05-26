package com.ozguryazilim.movie.repository;

import com.ozguryazilim.movie.model.CastModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CastRepository extends JpaRepository<CastModel,Long> {
    Optional<CastModel> findByCastname(String castname);
    Optional<CastModel> findTopByOrderByCastidDesc();
}
