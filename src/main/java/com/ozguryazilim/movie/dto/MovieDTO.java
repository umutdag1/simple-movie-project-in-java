package com.ozguryazilim.movie.dto;

import com.ozguryazilim.movie.model.MovieModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor

public class MovieDTO{

    private Long id;

    private String name;

    private String year;

    private String type;

    private String explanation;

    private String media;

    private List<LanguageDTO> lang;

    private List<CastDTO> cast;

    public MovieDTO(Long id, String name, String year, String type, String explanation, String media, List<LanguageDTO> lang, List<CastDTO> cast) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.type = type;
        this.explanation = explanation;
        this.media = media;
        this.lang = lang;
        this.cast = cast;
    }

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
}
