package com.ozguryazilim.movie.repository;

import com.ozguryazilim.movie.model.LanguageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageModel,Long> {
    Optional<LanguageModel> findByLangname(String langname);
    Optional<LanguageModel> findTopByOrderByLangidDesc();
}
