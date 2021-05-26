package com.ozguryazilim.movie.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "languages")
public class LanguageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lang_id")
    @Getter
    private Long langid;

    @Column(name = "lang_name",length = 255)
    @Getter
    @Setter
    private String langname;

}