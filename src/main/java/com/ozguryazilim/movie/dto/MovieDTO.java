package com.ozguryazilim.movie.dto;

import com.ozguryazilim.movie.model.MovieModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class MovieDTO implements Serializable {

    private Long id;

    private String name;

    private String year;

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
                CastDTO.ofList(movieModel.getCast()));
    }
}
