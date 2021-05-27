package com.ozguryazilim.movie.dto;

import com.ozguryazilim.movie.model.LanguageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageDTO{
    private Long langid;

    private String langname;

    public static LanguageDTO of(LanguageModel languageModel){
        return new LanguageDTO(languageModel.getLangid(),languageModel.getLangname());
    }

    public static List<LanguageDTO> ofList(List<LanguageModel> languageModel){
        return languageModel.stream().map(LanguageDTO::of).collect(Collectors.toList());
    }
}
