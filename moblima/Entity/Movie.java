package moblima.Entity;

import java.io.Serializable;
import java.util.*;

/**
 * Represents a Movie.
 * Concrete class that implements the Serializable interface.
 */
public abstract class Movie implements Serializable {
    /**
     * The ratings of this Movie.
     */
    private ArrayList<Float> ratings;
    /**
     * The movieID of this Movie.
     */
    private int movieID;
    /**
     * The reviews of this Movie.
     */
    private ArrayList<String> reviews;
    /**
     * The average ratings of this Movie.
     */
    private float averageRatings;
    /**
     * The title of this Movie.
     */
    private String title;
    /**
     * The sypnosis of this Movie.
     */
    private String synopsis;
    /**
     * The status of this Movie.
     */
    private ShowingStatus status;
    /**
     * The director of this Movie.
     */
    private String director;
    /**
     * The cast of this Movie.
     */
    private ArrayList<String> cast;
    /**
     * The sales count of this Movie.
     */
    private int numSales;
    /**
     * The price constant of this Movie.
     */
    protected double priceProportion;
    /**
     * The serialVersionUID of this Movie.
     */
    private static final long serialVersionUID = 4361251724076664901L;

    /**
     * Creates a new Movie with given title, sypnosis, status, director, cast,
     * movieID.
     * 
     * @param title    This Movie's title.
     * @param sypnosis This Movie's sypnosis.
     * @param status   This Movie's status.
     * @param director This Movie's director.
     * @param cast     This Movie's cast.
     * @param movieID  This Movie's movieID.
     * @param price    This Movie's price.
     * @param type     This Movie's type.
     */
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
        this.priceProportion = priceProportion;
        ratings = new ArrayList<Float>();
        reviews = new ArrayList<String>();

    }

    /**
     * Gets the status of this Movie.
     * 
     * @return this Movie's status.
     */
    public ShowingStatus getStatus() {
        return status;
    }

    /**
     * Gets the cast of this Movie..
     * 
     * @return this Movie's cast.
     */
    public ArrayList<String> getCast() {
        return cast;
    }

    /**
     * Gets the title of this Movie.
     * 
     * @return this Movie's title.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Gets the identification number of this Movie.
     * 
     * @return this Movie's movieID.
     */
    public int getMovieID() {
        return this.movieID;
    }

    /**
     * Gets the sypnosis of this Movie.
     * 
     * @return this Movie's sypnosis.
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Gets the director of this Movie.
     * 
     * @return this Movie's director.
     */
    public String getDirector() {
        return director;
    }

    /**
     * Appends a new review to ArrayList of reviews.
     * 
     * @param review This Movie's new review.
     */
    public void addReview(String review) {
        reviews.add(review);
    }

    /**
     * Adds a new rating to current average rating and computes a new average
     * rating.
     * 
     * @param rating This Movie's new rating.
     */
    public void addRatings(float rating) {
        ratings.add(rating);
        float sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            System.out.println("Rating is " + ratings.get(i));
            sum += ratings.get(i);
        }
        this.averageRatings = sum / ratings.size();
    }

    /**
     * Gets the average rating of this Movie.
     * If there are no existing ratings, return 0.
     * 
     * @return this Movie's averageRatings.
     */
    public float getAverageRatings() {
        if (ratings.size() > 1) {
            return averageRatings;
        } else {
            return 0;
        }
    }

    /**
     * Gets the total number of sales of this Movie.
     * 
     * @return this Movie's numSales.
     */
    public int getNumSales() {
        return numSales;
    }

    /**
     * Gets the reviews of this Movie.
     * 
     * @return this Movie's reviews.
     */
    public ArrayList<String> getReviews() {
        return reviews;
    }

    /**
     * Changes the status of this Movie.
     * 
     * @param status This Movie's status.
     */
    public void setStatus(ShowingStatus status) {
        this.status = ShowingStatus.END_OF_SHOWING;
    }

    /**
     * Gets the price proportion constant for this Movie.
     * 
     * @return this Movie's price.
     */
    public double getPriceProportion() {
        return priceProportion;
    };

    /**
     * Mutator method to change price proportion of the movie.
     * 
     * @param the new price.
     */
    public void setPriceProportion(double newPrice) {
        this.priceProportion = newPrice;
        return;
    }

    public abstract String printType();

}