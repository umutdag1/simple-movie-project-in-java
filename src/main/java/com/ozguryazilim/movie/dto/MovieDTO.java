package com.ozguryazilim.movie.dto;

import com.ozguryazilim.movie.model.LanguageModel;
import com.ozguryazilim.movie.model.MovieModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MovieDTO{

    private Long id;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;

    private String type;

    private String explanation;

    private String media;

    private List<LanguageDTO> lang;

    private List<CastDTO> cast;


    public static MovieDTO of(MovieModel movieModel){
        return new MovieDTO(
                movieModel.getId(),
                movieModel.getName(),
                movieModel.getYear(),
                movieModel.getType(),
                movieModel.getExplanation(),
                movieModel.getMedia(),
                LanguageDTO.ofList(movieModel.getLang()),
                CastDTO.ofList(movieModel.getCast())
        );
    }

    public static List<MovieDTO> ofList(List<MovieModel> movieModel){
        return movieModel.stream().map(MovieDTO::of).collect(Collectors.toList());
    }
}
