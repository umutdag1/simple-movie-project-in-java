package com.ozguryazilim.movie.dto;

import com.ozguryazilim.movie.model.CastModel;
import com.ozguryazilim.movie.model.LanguageModel;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class CastDTO {
    private Long castid;
    private String castname;

    public static CastDTO of(CastModel castModel){
        return new CastDTO(castModel.getCastid(),castModel.getCastname());
    }

    public static List<CastDTO> ofList(List<CastModel> castModel){
        return castModel.stream().map(CastDTO::of).collect(Collectors.toList());
    }
}
