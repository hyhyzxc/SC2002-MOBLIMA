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
public class CustomerUI {
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
        this.owner = account;
        this.managerList = managerList;
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
            System.out.println("Type: " + movieList.get(i).printType());
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

    /**
     * Shows the Top 5 Movies by the Ratings. If only one movie exists, then don't
     * show at all. If staff disabled customer from filtering by rating, then
     * return.
     */
    public void showTop5Movies() {
        SortContext sortContext = new SortContext(new SortByRatings());
        LinkedHashMap<String, Float> hm = sortContext.executeSort();
        int size = hm.size();
        if (size <= 1) {
            System.out.println("Sorry there's only one or less movies");
            return;
        }
        int i = 1;
        System.out.println("Movie Title: Ratings");
        for (String movieName : hm.keySet()) {
            if (i == 6)
                return;
            System.out.println("------------------------------------");
            System.out.println("Rank: " + i++);
            System.out.println("Movie: " + movieName);
            System.out.println("Rating: " + hm.get(movieName));
            System.out.println("------------------------------------");
        }
    }

    public void showTop5MoviesBySales() {
        SortContext sortContext = new SortContext(new SortBySales());
        LinkedHashMap<String, Float> hm = sortContext.executeSort();
        int size = hm.size();
        if (size <= 1) {
            System.out.println("Sorry there's only one or less movies");
            return;
        }
        int i = 1;
        System.out.println("Movie Title: Num of Sales");
        for (String movieName : hm.keySet()) {
            if (i == 6)
                return;
            System.out.println("------------------------------------");
            System.out.println("Rank: " + i++);
            System.out.println("Movie: " + movieName);
            System.out.println("Num of Sales: " + hm.get(movieName));
            // System.out.printf("Rank: %d\nMovie: %d\nNum of Sales: %f\n", i++, movieName,
            // hm.get(movieName));
            System.out.println("------------------------------------");
        }
    }

    /**
     * Initialises CustomerUI.
     * Displays user's options and calls relevant methods and UIs.
     * 
     * @throws InvalidEmailException
     * @throws InvalidPhoneNoException
     */
    public void init() throws InvalidEmailException, InvalidPhoneNoException {
        int choice = 0;
        StaffConfigs staffc = new StaffConfigs();
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
            System.out.println("Option 6: View Top 5 Movies by Rating");
            System.out.println("Option 7: View Top 5 Movies by Ticket Sales");
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
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    return;
                case 1:
                    showAllMovieDetails();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    try {
                        addRatingAndReview();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());

                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    BookingUI UI = new BookingUI(owner, managerList);
                    try {
                        UI.viewSeatAvailability();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 4:
                    BookingUI bUI = new BookingUI(owner, managerList);
                    bUI.init();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 5:
                    BookingHistoryUI BHUI = new BookingHistoryUI(owner, managerList);
                    BHUI.init();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 6:
                    if (staffc.getCurrentConfigs().get("VIEW_BY_RATINGS") == false) {
                        System.out.println("Viewing by ratings disabled, sorry, please consult a staff");
                        System.out.println(
                                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        break;
                    }
                    showTop5Movies();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 7:
                    if (staffc.getCurrentConfigs().get("VIEW_BY_NUM_SALES") == false) {
                        System.out.println("Viewing by number of sales disabled, sorry, please consult a staff");
                        System.out.println(
                                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        break;
                    }
                    showTop5MoviesBySales();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                default:
                    showErrorMessage();
            }
        } while (1 <= choice && choice <= 7);
        System.out.println("exited");
    }
}
