package moblima.Entity;

import java.util.*;

public class Cineplex {
    private String location;
    private ArrayList<Cinema> theatres;
    private ArrayList<Movie> availableMovieList;

    public Cineplex(String location, ArrayList<Cinema> theatres, ArrayList<Movie> movieList) {
        this.location = location;
        this.theatres = new ArrayList<Cinema>();
        this.availableMovieList = movieList;
    }

    public String getLocation() {
        return location;
    }

    public ArrayList<Cinema> getTheatres() {
        return theatres;
    }

    public ArrayList<Movie> getAvailableMovies() {
        return availableMovieList;
    }
}
