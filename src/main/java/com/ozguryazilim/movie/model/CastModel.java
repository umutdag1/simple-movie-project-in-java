package com.ozguryazilim.movie.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "casts")
public class CastModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cast_id")
    @Getter
    @Setter
    private Long castid;

    @Column(name = "cast_name",length = 50)
    @Getter
    @Setter
    private String castname;


}
