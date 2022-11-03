import java.util.*;

public class Movie {
    private ArrayList<Float> ratings;
    private int movieID;
    private ArrayList<String> reviews;
    private float averageRatings;
    private String title;
    private String synopsis;
    private ShowingStatus status;
    private String director;
    private ArrayList<String> cast;

    public Movie(String title, String sypnosis, ShowingStatus status, String director, ArrayList<String> cast,
            int movieID) {
        this.title = title;
        this.synopsis = sypnosis;
        this.status = status;
        this.director = director;
        this.cast = cast;
        this.movieID = movieID;

    }

    public String getTitle() {
        return this.title;
    }

    public int getMovieID() {
        return this.movieID;
    }

    public String getDetails() {
        String castString = String.join(",", this.cast);
        String reviewString = String.join("\n", this.reviews);
        String details = "Movie Title: " + this.title + "\nSynopsis: " + this.synopsis + "\nDirector"
                + this.director + "\nCast: " + castString + "\nStatus" + this.status
                + "\nAverage Rating: " + getAverageRatings() + "\nReviews: " + reviewString;

        return details;
    }

    public void addReview(String review) {
        reviews.add(review);
    }

    public void addRatings(float rating) {
        ratings.add(rating);
        float average = 0;
        if (!ratings.isEmpty()) {
            for (Float value : ratings) {
                average += value;
            }
        }
        this.averageRatings = average;
    }

    public float getAverageRatings() {
        return averageRatings;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }

}
