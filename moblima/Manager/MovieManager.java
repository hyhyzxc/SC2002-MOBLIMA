package moblima.Manager;

import java.util.*;

import moblima.Entity.Movie;
import moblima.Entity.ShowingStatus;
import moblima.Serializer.MovieSerializer;
import moblima.UI.StaffUI;

import java.io.*;

/**
 * Represents a MovieManager.
 * 
 * @author
 * @version 1.0
 * @since 2022-11-11
 */
public class MovieManager {
    /**
     * ArrayList consisting of list of movies.
     */
    private ArrayList<Movie> movieList;

    /**
     * Number of movies.
     */
    private int numMovies;
    static MovieSerializer s = new MovieSerializer();

    /**
     * Creates a new MovieManager.
     */
    public MovieManager() {

        movieList = s.getMovieList("MovieDatabase.ser");
        if (movieList == null) {
            movieList = new ArrayList<Movie>();
        }
        numMovies = movieList.size();
    }

    /**
     * Adds a new movie to the list of movies.
     * Saves movie details to movie database.
     * Displays a message that movie was successfully added.
     * 
     * @param newMovie the new Movie to be added.
     */
    public void addNewMovie(Movie newMovie) {
        movieList.add(newMovie);
        s.saveMovieList(movieList, "MovieDatabase.ser");
        System.out.println("Movie Successfully Saved.");

    }

    /**
     * Removes a movie from the list of movies.
     * Sets movie status to End of Showing.
     * Displays a message that movie was successfully removed.
     * 
     * @param movieChoice the movie option from the list of movies.
     */
    public void removeMovie(int movieChoice) {
        Movie toRemove = movieList.get(movieChoice);
        toRemove.setStatus(ShowingStatus.END_OF_SHOWING);

        s.saveMovieList(movieList, "MovieDatabase.ser");
        System.out.println("Movie Successfully Removed");

    }

    /**
     * Adds rating to a selected choice of movie.
     * Saves movie rating to movie database.
     * 
     * @param rating   the rating to be given to this movie.
     * @param movieNum the movie option from the list of movies.
     */
    public void addNewMovieRating(float rating, int movieNum) {
        Movie movieToRate = movieList.get(movieNum);
        movieToRate.addRatings(rating);
        s.saveMovieList(movieList, "MovieDatabase.ser");
    }

    /**
     * Adds review to a selected choice of movie.
     * Saves movie review to movie database.
     * 
     * @param review   the review to be given to this movie.
     * @param movieNum the movie option from the list of movies.
     */
    public void addNewMovieReview(String review, int movieNum) {
        Movie movieToReview = movieList.get(movieNum);
        movieToReview.addReview(review);
        s.saveMovieList(movieList, "MovieDatabase.ser");
    }

    /**
     * Gets full movie list.
     * 
     * @return the full movie list.
     */
    public ArrayList<Movie> getMovieList() {
        movieList = s.getMovieList("MovieDatabase.ser");
        movieList.sort((m1, m2) -> Integer.compare(m1.getMovieID(), m2.getMovieID()));
        ArrayList<Movie> newList = new ArrayList<Movie>();
        for (Movie movie : movieList) {
            if (movie.getStatus() != ShowingStatus.END_OF_SHOWING) {
                newList.add(movie);
            }
        }
        return newList;
    }

    /**
     * Sorts movies by ratings.
     * 
     * @return the movie list sorted by ratings.
     */
    public ArrayList<Movie> getSorted() {
        movieList.sort((m1, m2) -> m1.getAverageRatings() > m2.getAverageRatings() ? -1 : 1);
        return movieList;
    }
}
