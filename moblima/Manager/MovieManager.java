package moblima.Manager;

import java.util.*;

import moblima.Entity.Movie;
import moblima.Entity.Sorter;
import moblima.Serializer.MovieSerializer;
import moblima.UI.StaffUI;

import java.io.*;

public class MovieManager implements Sorter {
    private ArrayList<Movie> movieList;
    private int numMovies;
    static MovieSerializer s = new MovieSerializer();

    public MovieManager() {

        movieList = s.getMovieList("MovieDatabase.ser");
        if (movieList == null) {
            movieList = new ArrayList<Movie>();
        }
        numMovies = movieList.size();
    }

    public void addNewMovie(Movie newMovie) {
        movieList.add(newMovie);
        s.saveMovieList(movieList, "MovieDatabase.ser");
        System.out.println("Movie Successfully Saved.");

    }

    public void removeMovie(int movieChoice) {
        movieList.remove(movieChoice);
        s.saveMovieList(movieList, "MovieDatabase.ser");
        System.out.println("Movie Successfully Removed");

    }

    public void addNewMovieRating(float rating, int movieNum) {
        Movie movieToRate = movieList.get(movieNum);
        movieToRate.addRatings(rating);
        s.saveMovieList(movieList, "MovieDatabase.ser");
    }

    public void addNewMovieReview(String review, int movieNum) {
        Movie movieToReview = movieList.get(movieNum);
        movieToReview.addReview(review);
        s.saveMovieList(movieList, "MovieDatabase.ser");
    }

    public ArrayList<Movie> getMovieList() {
        movieList = s.getMovieList("MovieDatabase.ser");
        movieList.sort((m1, m2) -> Integer.compare(m1.getMovieID(), m2.getMovieID()));
        return movieList;
    }
    
    public ArrayList<Movie> getSorted() {
    	movieList.sort((m1, m2) -> m1.getAverageRatings() > m2.getAverageRatings() ? -1 : 1);
    	return movieList;
    }
}
