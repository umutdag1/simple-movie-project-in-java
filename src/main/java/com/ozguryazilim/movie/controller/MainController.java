package com.ozguryazilim.movie.controller;

import com.ozguryazilim.movie.dto.CastDTO;
import com.ozguryazilim.movie.dto.LanguageDTO;
import com.ozguryazilim.movie.dto.MovieDTO;
import com.ozguryazilim.movie.model.CastModel;
import com.ozguryazilim.movie.model.LanguageModel;
import com.ozguryazilim.movie.model.MovieModel;
import com.ozguryazilim.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private MovieService movieService;

    @GetMapping({"/","showAllMovies"})
    public String showMovies(Model model) {
        List<MovieDTO> movieList = movieService.getAllMovie();

        model.addAttribute("movieList", movieList);
        return "hello";
    }

    @PostMapping("/movies/showMoviesByFilter")
    public String showMoviesByFilter(
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "cast", required = true) String cast,
            @RequestParam(value = "type", required = true) String type,
            Model model
    ) {
        List<MovieDTO> movieList = null;
        if(!name.trim().isEmpty() && !name.trim().isBlank()){
            movieList = movieService.getAllMovieByName(name.trim());
        } else if(!cast.trim().isEmpty() && !cast.trim().isBlank()){
            movieList = movieService.getAllMovieByCast(cast.trim());
        } else if(!type.trim().isEmpty() && !type.trim().isBlank()){
            movieList = movieService.getAllMovieByType(type.trim());
        } else {
            return "redirect:/showAllMovies";
        }

        model.addAttribute("movieList", movieList);
        return "hello";
    }

    @GetMapping("movies/edit/{id}")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        Optional<MovieDTO> movieDTO = movieService.getMovieById(id);
        List<CastDTO> castList = movieDTO.get().getCast();
        List<LanguageDTO> langList = movieDTO.get().getLang();
        String castToString = this.SpecialTypeToString(castList);
        String langToString = this.SpecialTypeToString(langList);

        model.addAttribute("movieId", id);
        model.addAttribute("movieDTO", movieDTO);
        model.addAttribute("castToStr", castToString);
        model.addAttribute("langToStr", langToString);
        return "editMovie";
    }

    @PostMapping("movies/saveEdit/{id}")
    public String saveEditMovie(
            @PathVariable("id") Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "year", required = true) String year,
            @RequestParam(value = "type", required = true) String type,
            @RequestParam(value = "explanation", required = true) String explanation,
            @RequestParam(value = "media", required = true) String media,
            @RequestParam(value = "language", required = true) String language,
            @RequestParam(value = "cast", required = true) String cast,
            Model model
    ) {
        String[] langs = language.split(",");
        String[] casts = cast.split(",");

        Optional<MovieModel> movieModelToUpdate = movieService.getMovieByIdAsModel(id);
        List<LanguageModel> languageModelList = new ArrayList<>();
        List<CastModel> castModelList = new ArrayList<>();

        if (movieModelToUpdate.isPresent()) {
            MovieModel movieModel = movieModelToUpdate.get();
            movieModel.setName(name);
            movieModel.setYear(year);
            movieModel.setType(type);
            movieModel.setExplanation(explanation);
            movieModel.setMedia(media);

            Long langLastInsertid =
                    movieService.getLangLastinsertId();
            for (String lang : langs) {
                Optional<LanguageModel> checkLangModelifExist =
                        movieService.getLanguageByNameAsModel(lang.trim());
                if (!checkLangModelifExist.isPresent()) {
                    langLastInsertid += 1;
                    LanguageModel languageModel =
                            new LanguageModel(langLastInsertid, lang.trim());
                    languageModelList.add(languageModel);
                } else {
                    languageModelList.add(checkLangModelifExist.get());
                }

            }

            Long castLastInsertid =
                    movieService.getCastLastinsertId();
            for (String c : casts) {
                Optional<CastModel> checkCastModelifExist =
                        movieService.getCastByNameAsModel(c.trim());
                if (!checkCastModelifExist.isPresent()) {
                    castLastInsertid += 1;
                    CastModel castModel = new CastModel(castLastInsertid, c.trim());
                    castModelList.add(castModel);
                } else {
                    castModelList.add(checkCastModelifExist.get());
                }
            }

            movieModel.setLang(languageModelList);
            movieModel.setCast(castModelList);

            movieService.saveMovie(movieModel);

        }

        model.addAttribute("returnedResponse", new String("Successfully Saved."));
        return "editMovie";
    }


    private String SpecialTypeToString(List<? extends Object> list) {
        StringBuilder strbul = new StringBuilder();
        String ToString = "";
        if (list.size() > 0) {
            if (list.get(0) instanceof CastDTO) {
                List<CastDTO> castDTOList = (List<CastDTO>) list;
                for (CastDTO castDTO : castDTOList) {
                    strbul.append(castDTO.getCastname());
                    strbul.append(",");
                }
            } else if (list.get(0) instanceof LanguageDTO) {
                List<LanguageDTO> languageDTOList = (List<LanguageDTO>) list;
                for (LanguageDTO langDTO : languageDTOList) {
                    strbul.append(langDTO.getLangname());
                    strbul.append(",");
                }
            }

            strbul.setLength(strbul.length() - 1);
            ToString = strbul.toString();
        }
        return ToString;
    }
}
