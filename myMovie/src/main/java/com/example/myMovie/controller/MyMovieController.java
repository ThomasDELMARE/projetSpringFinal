package com.example.myMovie.controller;

import com.example.myMovie.domain.Acteur;
import com.example.myMovie.domain.Film;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyMovieController {

    ArrayList<Film> moviesList = new ArrayList<>();
    ArrayList<Acteur> acteursList = new ArrayList<>();

    // Create movie db
    public MyMovieController(){
        Acteur acteur1 = new Acteur("Dicaprio", "Leonardo", new ArrayList<Film>(), new Date());
        Acteur acteur2 = new Acteur("Weaver", "Sigourney", new ArrayList<Film>(), new Date());
        this.acteursList.add(acteur1);
        this.acteursList.add(acteur2);

        Film film1 = new Film("Titanic", "Spielberg", acteur1, new Date());
        Film film2 = new Film("Avatar", "Cameron", acteur2, new Date());
        this.moviesList.add(film1);
        this.moviesList.add(film2);

    }

    // Mapping films
    @GetMapping("/movies/allMovies")
    public ArrayList<Film> getMovies() {
        return this.moviesList;
    }

    @GetMapping("/movies/nom/{nomFilm}")
    public ArrayList<Film> getMovieByNomFilm(@PathVariable String nomFilm) {
        ArrayList<Film> filmsParTitreFilm = new ArrayList<>();

        for(int i = 0; i < this.moviesList.size(); i++){
            if(this.moviesList.get(i).getTitre().equals(nomFilm)){
                filmsParTitreFilm.add(this.moviesList.get(i));
            }
        }

        return filmsParTitreFilm;
    }

    @GetMapping("/movies/date/{dateFilm}")
    public ArrayList<Film> getMovieByDate(@PathVariable String dateFilm) {
        ArrayList<Film> filmsParDate = new ArrayList<>();

        for(int i = 0; i < this.moviesList.size(); i++){
            System.out.println("Fetched year : " + this.moviesList.get(i).getDateDeSortie().getYear());
            if(this.moviesList.get(i).getDateDeSortie().getYear() == Integer.parseInt(dateFilm)){
                filmsParDate.add(this.moviesList.get(i));
            }
        }

        return filmsParDate;
    }

    @GetMapping("/movies/actor/{nomActeur}")
    public ArrayList<Acteur> getActeursByFilm(@PathVariable String nomActeur) {
        ArrayList<Acteur> acteursByFilm = new ArrayList<>();

        for(int i = 0; i < this.moviesList.size(); i++){
            for(int j = 0; j < this.acteursList.size(); j++){
                String nomActeurPrincipal = this.moviesList.get(i).getActeurPrincipal().getNom();
                String prenomActeurPrincipal = this.moviesList.get(i).getActeurPrincipal().getNom();
                String nomActeurList = this.acteursList.get(j).getNom();
                String prenomActeurList = this.acteursList.get(j).getPrenom();

                if(nomActeurPrincipal.equals(nomActeurList) && prenomActeurList.equals(prenomActeurPrincipal)){
                    acteursByFilm.add(this.acteursList.get(j));
                }
            }
        }

        return acteursByFilm;
    }


    // Mapping acteurs

    @GetMapping("/actors/allActors")
    public ArrayList<Acteur> getActeurs() {
        return this.acteursList;
    }

    @GetMapping("/actors/nom/{nomActeur}")
    public ArrayList<Acteur> getActeurByNom(@PathVariable String nomActeur) {
        ArrayList<Acteur> acteursParNom = new ArrayList<>();

        for(int i = 0; i < this.acteursList.size(); i++){
            if(this.acteursList.get(i).getNom().equals(nomActeur)){
                acteursParNom.add(this.acteursList.get(i));
            }
        }

        return acteursParNom;
    }


}
