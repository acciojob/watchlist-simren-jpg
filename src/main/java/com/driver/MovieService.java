package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired

    MovieRepository movieRepository;



    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public Movie getMovie(String name) {
        return movieRepository.getMovie(name);
    }

    public Director getDirector(String name) {
        return movieRepository.getDirector(name);
    }

    public String delete_director(String name) {
        return movieRepository.deleteDirector(name);
    }


    public List<String> findMoviesByDirector(String director) {
        return movieRepository.findMoviesByDirector(director);
    }

    public List<String> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String pair(String movieName, String directorName) {
        return movieRepository.pair_name(movieName , directorName);
    }

    public void deleteDirectors() {
        movieRepository.delete_allDirectors();
    }
}
