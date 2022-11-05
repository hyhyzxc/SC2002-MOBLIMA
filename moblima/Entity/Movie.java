package moblima.Entity;

import java.io.Serializable;
import java.util.*;

public class Movie implements Serializable {
    private ArrayList<Float> ratings;
    private int movieID;
    private ArrayList<String> reviews;
    private float averageRatings;
    private String title;
    private String synopsis;
    private ShowingStatus status;
    private String director;
    private ArrayList<String> cast;
    private int numSales;
    private static final long serialVersionUID = 4361251724076664901L;

    public Movie(String title, String sypnosis, ShowingStatus status, String director, ArrayList<String> cast,
            int movieID) {
        this.title = title;
        this.synopsis = sypnosis;
        this.status = status;
        this.director = director;
        this.cast = cast;
        this.movieID = movieID;
        this.averageRatings = 0;
        this.numSales = 0;
        ratings = new ArrayList<Float>();
        reviews = new ArrayList<String>();

    }

    public ShowingStatus getStatus() {
        return status;
    }

    public ArrayList<String> getCast() {
        return cast;
    }

    public String getTitle() {
        return this.title;
    }

    public int getMovieID() {
        return this.movieID;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getDirector() {
        return director;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public void addRatings(float rating) {
        ratings.add(rating);
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println("Rating is " + ratings.get(i));
            sum += ratings.get(i);
        }
        this.averageRatings = sum / ratings.size();
    }

    public float getAverageRatings() {
        if (ratings.size() > 1) {
            return averageRatings;
        } else {
            return 0;
        }
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

}
