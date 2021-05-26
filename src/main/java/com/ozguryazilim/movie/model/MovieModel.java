package com.ozguryazilim.movie.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
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

    @OneToMany
    @Getter
    @Setter
    private List<LanguageModel> lang;

    @ManyToMany
    @Getter
    @Setter
    private List<CastModel> cast;

}
