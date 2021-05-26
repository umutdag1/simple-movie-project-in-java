package com.ozguryazilim.movie.dto;

import com.ozguryazilim.movie.model.CastModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class CastDTO{
    private Long castid;
    private String castname;

    public CastDTO(Long castid, String castname) {
        this.castid = castid;
        this.castname = castname;
    }

    public static CastDTO of(CastModel castModel){
        return new CastDTO(castModel.getCastid(),castModel.getCastname());
    }

    public static List<CastDTO> ofList(List<CastModel> castModel){
        return castModel.stream().map(CastDTO::of).collect(Collectors.toList());
    }
}
