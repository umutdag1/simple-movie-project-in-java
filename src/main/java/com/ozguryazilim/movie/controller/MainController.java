package com.ozguryazilim.movie.controller;

import com.ozguryazilim.movie.dto.MovieDTO;
import com.ozguryazilim.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/")
    public String showMovies(Model model){
        List<MovieDTO> movieList = movieService.getAllMovie();

        System.out.println(movieList);

        model.addAttribute("movieList",movieList);
        return "hello";
    }
}
