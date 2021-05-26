package com.ozguryazilim.movie.service;

import com.ozguryazilim.movie.dto.MovieDTO;
import com.ozguryazilim.movie.model.CastModel;
import com.ozguryazilim.movie.model.LanguageModel;
import com.ozguryazilim.movie.model.MovieModel;
import com.ozguryazilim.movie.repository.CastRepository;
import com.ozguryazilim.movie.repository.LanguageRepository;
import com.ozguryazilim.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService{
    private final MovieRepository movieRepository;
    private final LanguageRepository languageRepository;
    private final CastRepository castRepository;

    @Override
    public List<MovieDTO> getAllMovie() {
        final List<MovieDTO> movieDTOList =
                movieRepository.findAll().stream().map(MovieDTO::of).collect(Collectors.toList());
        System.out.println(movieDTOList);
        return movieDTOList;
    }

    @Override
    public Optional<MovieDTO> getMovieById(Long id) {
        final Optional<MovieDTO> movieDTO =
                movieRepository.findById(id).map(MovieDTO::of);
        return movieDTO;
    }

    @Override
    public Optional<MovieModel> getMovieByIdAsModel(Long id) {
        final Optional<MovieModel> movieModel =
                movieRepository.findById(id);
        return movieModel;
    }

    @Override
    public void saveMovie(MovieModel movieModel) {
        movieRepository.save(movieModel);
    }

    @Override
    public Optional<LanguageModel> getLanguageByNameAsModel(String langname) {
        final Optional<LanguageModel> languageModel =
                languageRepository.findByLangname(langname);
        return languageModel;

    }

    @Override
    public Optional<CastModel> getCastByNameAsModel(String castname) {
        final Optional<CastModel> castModel =
                castRepository.findByCastname(castname);
        return castModel;

    }
}
