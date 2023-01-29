package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController  {
    @Autowired
    MovieService movieServices;


    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){

        movieServices.addMovie(movie);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){

        movieServices.addDirector(director);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity  getMovieByName(@RequestParam("name") String name){
        Movie movie= movieServices.getMovie(name);
        return new ResponseEntity<>(movie, HttpStatus.FOUND);
    }

    @GetMapping("/movies/get_director_by_name/{name}")
    public ResponseEntity  getDirectorByName(@RequestParam("name") String name){
        Director director= movieServices.getDirector(name);
        return new ResponseEntity<>(director, HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-director-by-name/{name}")
    public ResponseEntity deleteDirectorByName(@PathVariable("name") String name){
        String responce = movieServices.delete_director(name);
        if(responce == "Invalid name"){
            return new ResponseEntity(responce , HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(responce , HttpStatus.FOUND);
    }

    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity deleteAllDirectors(){
        movieServices.deleteDirectors();
        return new ResponseEntity<>("success" , HttpStatus.FOUND);
    }


    @GetMapping("/get_movies_by_director_name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies = movieServices.findMoviesByDirector(director);

        return new ResponseEntity<>(movies , HttpStatus.OK);
    }

    @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies = movieServices.findAllMovies();
        return new ResponseEntity<>(movies , HttpStatus.OK);
    }


    //3
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("a") String movieName ,@RequestParam("b") String directorName){
        movieServices.pair(movieName,directorName);
        return new ResponseEntity<>("success" , HttpStatus.OK);

    }



}
