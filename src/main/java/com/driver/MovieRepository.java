package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MovieRepository {

    Map<String , Movie> db = new HashMap<>();
    Map<String , Director> db_D = new HashMap<>();

    Map<String , String> pair = new HashMap<>();



    public String addMovie(Movie movie){
        String name = movie.getName();
        db.put(name,movie);
        return "Movie Added succesfully";
    }

    public Movie getMovie(String name){
        return db.get(name);
    }

    public String addDirector(Director director) {
        String name = director.getName();
        db_D.put(name,director);
        return "Director Added succesfully";
    }

    public Director getDirector(String name) {
        return db_D.get(name);
    }

    public String deleteDirector(String name) {
        if(!db_D.containsKey(name)){
            return "Invalid name";
        }
        db_D.remove(name);
        return "Director removed succesfully";
    }

    public String deleteMovie(String name) {
        if(!db.containsKey(name)){
            return "Invalid name";
        }
        db.remove(name);
        return "Movie  removed succesfully";
    }


    public List<String> findMoviesByDirector(String director) {
        List<String> movies = new ArrayList<>();
        for(String specific_director : pair.keySet()){
            if(specific_director.equals(director)){
                movies.add(pair.get(director));
            }

        }
        return movies;
    }

    public List<String> findAllMovies() {
        List<String> allMovies = new ArrayList<>();
        for(String eachMovie : db.keySet()){
            allMovies.add(eachMovie);
        }
        return allMovies;
    }

    public String pair_name(String movieName, String directorName) {
        pair.put(directorName ,movieName );
        return "Pair made";
    }



    public void delete_allDirectors() {
        db_D.clear();
    }
}