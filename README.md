# Projet Spring Final

Endpoints exposés :

- Eureka : http://localhost:8761/
- Hystrix Dashboard : http://localhost:8080/hystrix
- Actuator : localhost:8081/actuator et localhost:8082/actuator

- GET sur localhost:8081 et localhost:8082
  - /movies/allMovies
  - /movies/nom/{nomFilm}
  - /movies/date/{dateFilm}
  - /actors/nomFilm/{nomFilm}
  - /actors/allActors
  - /actors/nomActeur/{nomActeur}
- 
- UPDATE ET DELETE sur localhost:8081
  - /actors/delete/{nomActeur}
  - /movie/delete/{nomFilm}
  - /movie/update/{nomFilm}
  - /actor/update/{nomActeur}