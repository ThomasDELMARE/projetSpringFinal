package com.example.myfinder.controller;

import com.example.myfinder.delegate.MyFinderServiceDelegate;
import com.example.myfinder.domain.Acteur;
import com.example.myfinder.domain.Film;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;

@Api(value="MyMovieFinderController")
@RestController
public class MyMovieFinderController {

    @Autowired
    MyFinderServiceDelegate myFinderServiceDelegate;

    @ApiOperation(value = "Get all movies ", response = Iterable.class, tags = "getMovies")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movies/allMovies")
    public String getMovies() {
        return myFinderServiceDelegate.getMovies();
    }

    @ApiOperation(value = "Get movie by name ", response = Film.class, tags = "getMovieByNomFilm")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movies/nom/{nomFilm}")
    public String getMoviesByNomFilm(@PathVariable String nomFilm) {
        return myFinderServiceDelegate.getMoviesByNomFilm(nomFilm);
    }

    @ApiOperation(value = "Get movie by date ", response = Film.class, tags = "getMovieByDate")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/movies/date/{annee}")
    public String getMoviesByDate(@PathVariable String annee) {
        return myFinderServiceDelegate.getMoviesByDate(annee);
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
        return myFinderServiceDelegate.getActeursByFilm(nomFilm);
    }

    @ApiOperation(value = "Get all the actors ", response = Iterable.class, tags = "getAllActors")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/actors/allActors")
    public String getActeurs() {
        return myFinderServiceDelegate.getActeurs();
    }

    @ApiOperation(value = "Get actor by nom", response = Acteur.class, tags = "getActeurByNom")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 401, message = "Not authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not found") }
    )
    @GetMapping("/actors/nomActeur/{nomActeur}")
    public String getActeursByNom(@PathVariable String nomActeur) {
        return myFinderServiceDelegate.getActeurByNom(nomActeur);
    }
}
