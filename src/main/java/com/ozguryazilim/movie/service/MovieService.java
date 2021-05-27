package com.ozguryazilim.movie.service;

import com.ozguryazilim.movie.dto.MovieDTO;
import com.ozguryazilim.movie.model.CastModel;
import com.ozguryazilim.movie.model.LanguageModel;
import com.ozguryazilim.movie.model.MovieModel;

import java.util.List;
import java.util.Optional;

public interface MovieService {

    List<MovieDTO> getAllMovie();
    List<MovieDTO> getAllMovieByFilter(String cast,String name,String type);
    List<MovieDTO> getAllMovieByName(String name);
    List<MovieDTO> getAllMovieByCast(String cast);
    List<MovieDTO> getAllMovieByType(String type);
    Optional<MovieDTO> getMovieById(Long id);
    Optional<MovieModel> getMovieByIdAsModel(Long id);
    void saveMovie(MovieModel movieModel);
    Optional<LanguageModel> getLanguageByNameAsModel(String langname);
    Optional<CastModel> getCastByNameAsModel(String castname);
    Long getLangLastinsertId();
    Long getCastLastinsertId();
}
