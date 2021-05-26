package com.ozguryazilim.movie.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Table(name = "movies")
public class MovieModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    @Getter
    private Long id;

    @Column(name = "movie_name",length = 100)
    @Getter
    @Setter
    private String name;

    @Column(name = "movie_released_year",length = 5)
    @Getter
    @Setter
    private String year;

    @Column(name = "movie_type",length = 20)
    @Getter
    @Setter
    private String type;

    @Column(name = "movie_explanation",length = 50)
    @Getter
    @Setter
    private String explanation;

    @Column(name = "movie_media",length = 20)
    @Getter
    @Setter
    private String media;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<LanguageModel> lang;

    @ManyToMany(cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<CastModel> cast;

    public MovieModel(Long id,String name, String year, String type, String explanation, String media, List<LanguageModel> lang, List<CastModel> cast) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.type = type;
        this.explanation = explanation;
        this.media = media;
        this.lang = lang;
        this.cast = cast;
    }
}
