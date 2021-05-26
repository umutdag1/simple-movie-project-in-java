package com.ozguryazilim.movie.service;

import com.ozguryazilim.movie.dto.MovieDTO;
import com.ozguryazilim.movie.model.CastModel;
import com.ozguryazilim.movie.model.LanguageModel;
import com.ozguryazilim.movie.model.MovieModel;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDTO> getAllMovie();
    Optional<MovieDTO> getMovieById(Long id);
    Optional<MovieModel> getMovieByIdAsModel(Long id);
    void saveMovie(MovieModel movieModel);
    Optional<LanguageModel> getLanguageByNameAsModel(String langname);
    Optional<CastModel> getCastByNameAsModel(String castname);
}
