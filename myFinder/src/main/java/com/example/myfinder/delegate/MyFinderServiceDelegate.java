package com.example.myfinder.delegate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyFinderServiceDelegate {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getMoviesFallback")
    public String getMovies() {
        return this.restTemplate.exchange("http://localhost:8011/movies/allMovies/"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();
    }

    @HystrixCommand(fallbackMethod = "getMoviesByNomFilmFallback")
    public String getMoviesByNomFilm(String nomFilm) {
        return this.restTemplate.exchange("http://localhost:8011/movies/nom/{nomFilm}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();
    }

    @HystrixCommand(fallbackMethod = "getMoviesByDateFallback")
    public String getMoviesByDate(String annee) {
        return this.restTemplate.exchange("http://localhost:8011/movies/date/{annee}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();
    }

    @HystrixCommand(fallbackMethod = "getActeursByFilmFallback")
    public String getActeursByFilm(String nomFilm) {
        return this.restTemplate.exchange("http://localhost:8011/actors/nomFilm/{nomFilm}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();
    }

    @HystrixCommand(fallbackMethod = "getActeursFallback")
    public String getActeurs() {
        return this.restTemplate.exchange("http://localhost:8011/actors/allActors"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();
    }

    @HystrixCommand(fallbackMethod = "getActeursByNomFallback")
    public String getActeurByNom(String nomActeur) {
        return this.restTemplate.exchange("http://localhost:8011/actors/nomActeur/{nomActeur}"
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<String>() {
                }).getBody();
    }

    // Méthodes de fallback
    private String getMoviesFallback() {
        return "La méthode 'getMoviesFallback()' n'a pas été appelée car le serveur n'est pas disponible.";
    }

    private String getMoviesByNomFilmFallback(String nomFilm) {
        return "Nous n'avons pas pu récupérer la liste des films ayant le nom : " + nomFilm + " car le serveur ne semble pas disponible.";
    }

    private String getMoviesByDateFallback(String annee){
        return "Nous n'avons pas pu récupérer la liste des films sortis en : " + annee + " car le serveur ne semble pas disponible.";
    }

    private String getActeursByFilmFallback(String nomFilm){
        return "Nous n'avons pas pu récupérer la liste des acteurs pour le film : " + nomFilm + " car le serveur ne semble pas disponible.";
    }

    private String getActeursFallback(){
        return "Nous n'avons pas pu récupérer la liste des acteurs car le serveur ne semble pas disponible.";
    }

    private String getActeursByNomFallback(String nomActeur) {
        return "Nous n'avons pas pu récupérer la liste des films pour l'acteur : " + nomActeur + " car le serveur ne semble pas disponible.";
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
