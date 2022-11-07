package moblima.UI;

import java.util.*;

import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import moblima.Serializer.MovieSerializer;
import java.lang.*;

public class CustomerUI {

    private static CustomerAccount owner;
    private ManagerList managerList = new ManagerList();
    static final Scanner sc = new Scanner(System.in);
    static final CustomerUI customerUI = new CustomerUI(owner);

    public CustomerUI(CustomerAccount account) {
        this.owner = account;
    }

    public void getAllMovieDetails() {
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

    public void addRatingAndReview() throws InvalidInputException {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        customerUI.getAllMovieDetails();
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

    private static void showErrorMessage() {
        System.out.println("Invalid option. Please enter a valid option. ");
    }

    public void showTop5Movies() {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movies = MM.getSorted();
        System.out.println("Title (Rating):");
        for (int i = 0; i < 5; i++) {
            System.out.printf("%s (%f)\n", movies.get(i).getTitle(), movies.get(i).getAverageRatings());
        }
    }

    public void showTop5MovieBySales() {
        BookingManager BM = managerList.getBookingManager();
        Map<String, Integer> map = BM.sortMoviesBySales();
        for (Map.Entry<String, Integer> en : map.entrySet()) {
            System.out
                    .println("Movie Title: " + en.getKey() + "---->" + "Number of Sales: " + en.getValue());
        }
    }

    public void main() throws InvalidEmailException, InvalidPhoneNoException {
        int choice = 0;
        do {
            System.out.println("---------------------");
            System.out.println("    Customer Menu    ");
            System.out.println("---------------------");
            System.out.println("Hi! " + owner.getUsername());
            System.out.println("Select options:");
            System.out.println("Option 1: View All Movie Details");
            System.out.println("Option 2: Add Rating and Review to Movie");
            System.out.println("Option 3: Make Booking");
            System.out.println("Option 4: View Booking History");
            System.out.println("Option 5: View Top 5 Movies by Rating");
            System.out.println("Option 6: View Top 5 Movies by Ticket Sales");
            System.out.println("0: exit");

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
                    customerUI.getAllMovieDetails();
                    break;
                case 2:
                    try {
                        customerUI.addRatingAndReview();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                case 3:
                    BookingUI bUI = new BookingUI(owner);
                    bUI.main();
                    break;

                case 4:
                    BookingHistoryUI BHUI = new BookingHistoryUI(owner);
                    BHUI.main();
                    break;

                case 5:
                    customerUI.showTop5Movies();
                    break;

                case 6:
                    customerUI.showTop5MovieBySales();
                    break;

                default:
                    showErrorMessage();
            }
        } while (1 <= choice && choice <= 6);
        System.out.println("exited");
    }
}
