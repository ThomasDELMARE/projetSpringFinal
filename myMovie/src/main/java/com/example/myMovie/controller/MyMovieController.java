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
        ArrayList<String> nomFilms = new ArrayList<String>();

        for(int i = 0; i < this.moviesList.size(); i++){
            nomFilms.add(this.moviesList.get(i).getTitre());
        }

        return nomFilms.toString();
    }

    @ApiOperation(value = "Get movie by name ", response = Film.class, tags = "getMovieByNomFilm")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movies/nom/{nomFilm}")
    public String getMovieByNomFilm(@PathVariable String nomFilm) {
        ArrayList<String> filmsParTitreFilm = new ArrayList<String>();

        for(int i = 0; i < this.moviesList.size(); i++){
            if(this.moviesList.get(i).getTitre().equals(nomFilm)){
                filmsParTitreFilm.add(this.moviesList.get(i).getTitre());
            }
        }

        return filmsParTitreFilm.toString();
    }

    @ApiOperation(value = "Get movie by date ", response = Film.class, tags = "getMovieByDate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movies/date/{dateFilm}")
    public String getMovieByDate(@PathVariable String dateFilm) {
        ArrayList<String> filmsParDate = new ArrayList<String>();

        for(int i = 0; i < this.moviesList.size(); i++){
            System.out.println("Fetched year : " + this.moviesList.get(i).getDateDeSortie().getYear());
            if(this.moviesList.get(i).getDateDeSortie().getYear() == Integer.parseInt(dateFilm)){
                filmsParDate.add(this.moviesList.get(i).getTitre());
            }
        }

        return filmsParDate.toString();
    }

    @ApiOperation(value = "Get acteurs by film ", response = Acteur.class, tags = "getActeursByFilm")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/actors/nomFilm/{nomFilm}")
    public String getActeursByFilm(@PathVariable String nomFilm) {
        ArrayList<String> acteursByFilm = new ArrayList<String>();

        for(int i = 0; i < this.moviesList.size(); i++){
            if(this.moviesList.get(i).getTitre().equals(nomFilm)){
                acteursByFilm.add(this.moviesList.get(i).getActeurPrincipal().getNom());
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
        ArrayList<String> nomActeurs = new ArrayList<String>();

        for(int i = 0; i < this.acteursList.size(); i++){
            nomActeurs.add(this.acteursList.get(i).getNom());
        }

        return nomActeurs.toString();
    }

    @ApiOperation(value = "Get actor by nom", response = Acteur.class, tags = "getActeurByNom")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/actors/nomActeur/{nomActeur}")
    public String getActeurByNom(@PathVariable String nomActeur) {
        ArrayList<String> acteursParNom = new ArrayList<String>();

        for(int i = 0; i < this.acteursList.size(); i++){
            if(this.acteursList.get(i).getNom().equals(nomActeur)){
                acteursParNom.add(this.acteursList.get(i).getNom());
            }
        }

        return acteursParNom.toString();
    }

    @ApiOperation(value = "Delete actor by nom", response = Acteur.class, tags = "deleteActeurByNom")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/actors/delete/{nomActeur}")
    public void deleteActeurByNom(@PathVariable String nomActeur) {
        for(int i = 0; i < this.acteursList.size(); i++){
            if(this.acteursList.get(i).getNom().equals(nomActeur)){
                this.acteursList.remove(i);
            }
        }
    }

    @ApiOperation(value = "Delete movie by nom", response = Acteur.class, tags = "deleteMovieByNom")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movie/delete/{nomFilm}")
    public void deleteMovieByNom(@PathVariable String nomFilm) {
        for(int i = 0; i < this.moviesList.size(); i++){
            if(this.moviesList.get(i).getTitre().equals(nomFilm)){
                this.moviesList.remove(i);
            }
        }
    }

    @ApiOperation(value = "Update movie name", response = Acteur.class, tags = "updateMovieByNom")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movie/update/{nomFilm}")
    public void updateMovieByNom(@PathVariable String nomFilm) {
        for(int i = 0; i < this.moviesList.size(); i++){
            if(this.moviesList.get(i).getTitre().equals(nomFilm)){
                this.moviesList.get(i).setTitre(nomFilm);
            }
        }
    }

    @ApiOperation(value = "Update actor name", response = Acteur.class, tags = "updateActorByNom")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/actor/update/{nomActeur}")
    public void updateActorByNom(@PathVariable String nomActeur) {
        for(int i = 0; i < this.acteursList.size(); i++){
            if(this.acteursList.get(i).getNom().equals(nomActeur)){
                this.acteursList.get(i).setNom(nomActeur);
            }
        }
    }
}
