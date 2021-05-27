package com.ozguryazilim.movie.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date year;

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

}
