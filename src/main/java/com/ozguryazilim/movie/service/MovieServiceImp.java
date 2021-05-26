package com.ozguryazilim.movie.service;

import com.ozguryazilim.movie.dto.MovieDTO;
import com.ozguryazilim.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieServiceImp implements MovieService{
    private final MovieRepository movieRepository;

    @Override
    public List<MovieDTO> getAllMovie() {
        final List<MovieDTO> movieDTOList =
                movieRepository.findAll().stream().map(MovieDTO::of).collect(Collectors.toList());
        System.out.println(movieDTOList);
        return movieDTOList;
    }
}
