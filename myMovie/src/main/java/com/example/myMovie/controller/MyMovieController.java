package com.example.myMovie.controller;

import com.example.myMovie.domain.Acteur;
import com.example.myMovie.domain.Film;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@Api(value="MyMovieController")
@RestController
public class MyMovieController {
    ArrayList<Film> moviesList = new ArrayList<Film>();
    ArrayList<Acteur> acteursList = new ArrayList<Acteur>();

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

    @ApiOperation(value = "Get all movies ", response = Iterable.class, tags = "getMovies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movies/allMovies")
    public String getMovies() {
        return this.moviesList.toString();
    }

    @ApiOperation(value = "Get movie by name ", response = Film.class, tags = "getMovieByNomFilm")
    @GetMapping("/movies/nom/{nomFilm}")
    public String getMovieByNomFilm(@PathVariable String nomFilm) {
        ArrayList<Film> filmsParTitreFilm = new ArrayList<Film>();

        for(int i = 0; i < this.moviesList.size(); i++){
            if(this.moviesList.get(i).getTitre().equals(nomFilm)){
                filmsParTitreFilm.add(this.moviesList.get(i));
            }
        }

        return filmsParTitreFilm.toString();
    }

    @ApiOperation(value = "Get movie by date ", response = Film.class, tags = "getMovieByDate")
    @GetMapping("/movies/date/{dateFilm}")
    public String getMovieByDate(@PathVariable String dateFilm) {
        ArrayList<Film> filmsParDate = new ArrayList<Film>();

        for(int i = 0; i < this.moviesList.size(); i++){
            System.out.println("Fetched year : " + this.moviesList.get(i).getDateDeSortie().getYear());
            if(this.moviesList.get(i).getDateDeSortie().getYear() == Integer.parseInt(dateFilm)){
                filmsParDate.add(this.moviesList.get(i));
            }
        }

        return filmsParDate.toString();
    }

    @ApiOperation(value = "Get movie by actor ", response = Acteur.class, tags = "getActeursByFilm")
    @GetMapping("/actors/nomFilm/{nomFilm}")
    public String getActeursByFilm(@PathVariable String nomFilm) {
        ArrayList<Acteur> acteursByFilm = new ArrayList<Acteur>();

        for(int i = 0; i < this.moviesList.size(); i++){
            if(this.moviesList.get(i).getTitre().equals(nomFilm)){
                acteursByFilm.add(this.moviesList.get(i).getActeurPrincipal());
            }
        }

        return acteursByFilm.toString();
    }


    // Mapping acteurs
    @ApiOperation(value = "Get all the actors ", response = Iterable.class, tags = "getAllActors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/actors/allActors")
    public String getActeurs() {
        return this.acteursList.toString();
    }

    @ApiOperation(value = "Get actor by nom", response = Acteur.class, tags = "getActeurByNom")
    @GetMapping("/actors/nomActeur/{nomActeur}")
    public String getActeurByNom(@PathVariable String nomActeur) {
        ArrayList<Acteur> acteursParNom = new ArrayList<Acteur>();

        for(int i = 0; i < this.acteursList.size(); i++){
            if(this.acteursList.get(i).getNom().equals(nomActeur)){
                acteursParNom.add(this.acteursList.get(i));
            }
        }

        return acteursParNom.toString();
    }


}
