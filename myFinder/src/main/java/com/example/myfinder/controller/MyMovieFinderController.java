package com.example.myfinder.controller;

import com.example.myfinder.delegate.MyFinderServiceDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyMovieFinderController {

    @Autowired
    MyFinderServiceDelegate myFinderServiceDelegate;

    @GetMapping("/movies/allMovies")
    public String getMovies() {
        return myFinderServiceDelegate.getMovies();
    }

    @GetMapping("/movies/nom/{nomFilm}")
    public String getMoviesByNomFilm(@PathVariable String nomFilm) {
        return myFinderServiceDelegate.getMoviesByNomFilm(nomFilm);
    }

    @GetMapping("/movies/date/{annee}")
    public String getMoviesByDate(@PathVariable String annee) {
        return myFinderServiceDelegate.getMoviesByDate(annee);
    }

    @GetMapping("/actors/nomFilm/{nomFilm}")
    public String getActeursByFilm(@PathVariable String nomFilm) {
        return myFinderServiceDelegate.getActeursByFilm(nomFilm);
    }

    @GetMapping("/actors/allActors")
    public String getActeurs() {
        return myFinderServiceDelegate.getActeurs();
    }

    @GetMapping("/actors/nomActeur/{nomActeur}")
    public String getActeursByNom(@PathVariable String nomActeur) {
        return myFinderServiceDelegate.getActeurByNom(nomActeur);
    }
}
