package moblima.UI;

import java.util.*;

import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import moblima.Serializer.MovieSerializer;
import java.lang.*;

/**
 * Handles all user IO for current Customer
 * 
 * @author
 *
 */
public class CustomerUI extends UserUI {
    /**
     * The CustomerAccount logged into the UI.
     */
    private static CustomerAccount owner;
    /**
     * This CustomerUI's list of managers.
     */
    private ManagerList managerList;
    /**
     * Static Scanner object for all IO.
     */
    static final Scanner sc = new Scanner(System.in);

    /**
     * Creates new CustomerUI with given account and managerList.
     * 
     * @param account     Current account logged into the UI.
     * @param managerList List of Managers.
     */
    public CustomerUI(CustomerAccount account, ManagerList managerList) {
        super(account, managerList);
    }

    /**
     * Calls MovieManager for MovieList and displays all movie details.
     */
    public void showAllMovieDetails() {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        if (movieList == null) {
            System.out.println("No movies in database");
            return;
        }
        for (int i = 0; i < movieList.size(); i++) {
            System.out.println("------------------");
            System.out.println("Movie No: " + (i + 1));
            System.out.println("Title: " + movieList.get(i).getTitle());
            System.out.println("Synopsis: " + movieList.get(i).getSynopsis());
            System.out.println("Status: " + movieList.get(i).getStatus().toString());
            System.out.println("Director: " + movieList.get(i).getDirector());
            ArrayList<String> castList = movieList.get(i).getCast();
            String castString = "|" + String.join("|", castList);
            System.out.println("Cast: " + castString);
            double avgRatings = Math.round(movieList.get(i).getAverageRatings() * 10) / 10.0;
            if (avgRatings != 0)
                System.out.println("Average Ratings: " + avgRatings);
            else
                System.out.println("Average Ratings: NA");
            ArrayList<String> reviews = movieList.get(i).getReviews();
            for (int j = 0; j < reviews.size(); j++) {
                System.out.println("Review " + (j + 1) + ": " + reviews.get(j));
            }

            System.out.println("------------------");
        }
    }

    /**
     * Allows user to input ratings and reviews for a movie.
     * 
     * @throws InvalidInputException
     */
    public void addRatingAndReview() throws InvalidInputException {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        showAllMovieDetails();
        System.out.println("Choose the Movie Number to rate.");

        int choice = sc.nextInt();
        if (!(choice >= 1 && choice <= movieList.size())) {
            throw new InvalidInputException();
        }
        System.out.println("Enter the rating from 1 - 5");
        float rating = sc.nextFloat();
        if (rating < 1 || rating > 5) {
            throw new InvalidInputException();
        }
        MM.addNewMovieRating(rating, choice - 1);
        System.out.println("Rating made!");

        System.out.println("Enter review. Press Enter to terminate. ");
        sc.nextLine();
        String review = sc.nextLine();
        MM.addNewMovieReview(review, choice - 1);
        System.out.println("Review made!");
    }

    /**
     * Displays error message if input is invalid.
     */
    private static void showErrorMessage() {
        System.out.println("Invalid option. Please enter a valid option. ");
    }

    // /**
    // * Uses MovieManager and displays top 5 movies ranked by rating.
    // */
    // public void showTop5Movies() {
    // MovieManager MM = managerList.getMovieManager();
    // ArrayList<Movie> movies = MM.getSortedRating();
    // System.out.println("Title (Rating):");
    // for (int i = 0; i < 5; i++) {
    // System.out.printf("%s (%f)\n", movies.get(i).getTitle(),
    // movies.get(i).getAverageRatings());
    // }
    // }

    // /**
    // * Uses Booking Manager and displays top 5 movies ranked by sales.
    // */
    // public void showTop5MovieBySales() {
    // BookingManager BM = managerList.getBookingManager();
    // Map<String, Integer> map = BM.sortMoviesBySales();
    // for (Map.Entry<String, Integer> en : map.entrySet()) {
    // System.out
    // .println("Movie Title: " + en.getKey() + "---->" + "Number of Sales: " +
    // en.getValue());
    // }
    // }

    /**
     * Initialises CustomerUI.
     * Displays user's options and calls relevant methods and UIs.
     * 
     * @throws InvalidEmailException
     * @throws InvalidPhoneNoException
     */
    public void init() throws InvalidEmailException, InvalidPhoneNoException {
        int choice = 0;
        do {
            System.out.println("---------------------");
            System.out.println("    Customer Menu    ");
            System.out.println("---------------------");
            System.out.println("Hi! " + owner.getUsername());
            System.out.println("Select options:");
            System.out.println("Option 1: View All Movie Details");
            System.out.println("Option 2: Add Rating and Review to Movie");
            System.out.println("Option 3: View Seat Availability");
            System.out.println("Option 4: Make Booking");
            System.out.println("Option 5: View Booking History");
            System.out.println("Option 6: Sort Movies");
            System.out.println("Enter 0 to exit");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
                showErrorMessage();
                continue;
            }
            switch (choice) {
                case 0:
                    System.out.println("Goodbye!" + owner.getUsername());
                    return;
                case 1:
                    showAllMovieDetails();
                    break;
                case 2:
                    try {
                        addRatingAndReview();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 3:
                    BookingUI UI = new BookingUI(owner, managerList);
                    try {
                        UI.viewSeatAvailability();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    BookingUI bUI = new BookingUI(owner, managerList);
                    bUI.init();
                    break;

                case 5:
                    BookingHistoryUI BHUI = new BookingHistoryUI(owner, managerList);
                    BHUI.init();
                    break;

                case 6:
                    System.out.println("(1) by Ranking \n(2) by Ticket Sales\n");
                    int c = sc.nextInt();
                    ArrayList<Movie> sortedList = new MovieManager().getSorted(c);
                    for (Movie movie : sortedList) {
                        System.out.println("----------------------------------------");
                        System.out.println("Title: " + movie.getTitle());
                        System.out.println("Avg Ratings: " + movie.getAverageRatings());
                        System.out.println("Num Sales: " + movie.getNumSales());
                        System.out.println("----------------------------------------");
                    }
                    break;
                // case 7:
                // showTop5MovieBySales();
                // break;

                default:
                    showErrorMessage();
            }
        } while (1 <= choice && choice <= 7);
        System.out.println("exited");
    }
}
