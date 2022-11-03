import java.util.*;
import java.io.*;

public class MovieManager {
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
        StaffUI.main(null);
    }

    public ArrayList<Movie> getMovieList() {
        movieList = s.getMovieList("MovieDatabase.ser");
        return movieList;
    }
}
