package moblima.UI;

import java.lang.reflect.Array;
import java.util.*;

import moblima.Database.*;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;

public class StaffUI {
    static final Scanner sc = new Scanner(System.in);
    static final Random r = new Random();
    private static StaffAccount owner;
    private ManagerList managerList = new ManagerList();
    static final StaffUI staffUI = new StaffUI(owner);

    public StaffUI(StaffAccount account) {
        this.owner = account;
    }

    public void addNewMovie() throws InvalidInputException {
        try {
            MovieManager MM = managerList.getMovieManager();
            System.out.println("Please enter the movie title.");
            String title = sc.nextLine();

            System.out.println("Please enter the synopsis.");
            String synopsis = sc.nextLine();
            System.out.println("Please enter Showing Status.");
            System.out.println("1: Coming Soon");
            System.out.println("2: Preview");
            System.out.println("3: Now Showing");
            System.out.println("4: End of Showing");
            int statusChoice = sc.nextInt();
            if (statusChoice < 1 || statusChoice > 3) {
                throw new InvalidInputException();
            }
            ShowingStatus status = (statusChoice == 1) ? ShowingStatus.COMING_SOON
                    : (statusChoice == 2) ? ShowingStatus.PREVIEW
                            : (statusChoice == 3) ? ShowingStatus.NOW_SHOWING : ShowingStatus.END_OF_SHOWING;
            System.out.println("Please enter Director name.");
            sc.nextLine();
            String director = sc.nextLine();
            ArrayList<String> cast = new ArrayList<>();
            String newCast;
            do {
                System.out.println("Please enter cast. Press enter without inputting to terminate.");
                newCast = sc.nextLine();
                cast.add(newCast);
            } while (!newCast.isEmpty());
            int movieID = r.nextInt(100000);
            Movie newMovie = new Movie(title, synopsis, status, director, cast, movieID);
            MM.addNewMovie(newMovie);
        } catch (Exception e) {
            System.out.println("Error input!");
            staffUI.main(null);
        }

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

            System.out.println("Average Ratings: " + avgRatings);
            ArrayList<String> reviews = movieList.get(i).getReviews();
            for (int j = 0; j < reviews.size(); j++) {
                System.out.println("Review " + (j + 1) + ": " + reviews.get(j));
            }

            System.out.println("------------------");
        }
    }

    public void removeMovie() throws InvalidInputException {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        staffUI.getAllMovieDetails();
        System.out.println("Choose the movie");
        int choice = sc.nextInt();
        if (choice < 1 || choice > movieList.size()) {
            throw new InvalidInputException();
        }
        MM.removeMovie(choice - 1);

    }

    public static void main(String[] args) {

        int choice = 0;
        System.out.println("------------------");
        System.out.println("    Staff Menu    ");
        System.out.println("------------------");
        System.out.println("Select options:");
        System.out.println("Option 1: Add New Movie");
        System.out.println("Option 2: Get Movie List");
        System.out.println("Option 3: Remove Movie");

        do {
            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                sc.nextLine();
                showErrorMessage();
                continue;
            }
            switch (choice) {
                case 1:
                    try {
                        staffUI.addNewMovie();
                    } catch (InvalidInputException e) {
                        e.getMessage();
                    }
                    staffUI.main(null);
                    break;

                case 2:
                    staffUI.getAllMovieDetails();
                    staffUI.main(null);
                    break;

                case 3:
                    try {
                        staffUI.removeMovie();
                    } catch (InvalidInputException e) {
                        e.getMessage();
                    }
                    staffUI.main(null);
                default:
                    showErrorMessage();
            }
        } while (!(0 <= choice && choice <= 3));
    }

    private static void showErrorMessage() {
        System.out.println("Invalid option. Please enter a valid option. ");
    }

    /*
     * public void showUpdateMovieListingMenu() {
     * int choice = 0;
     * System.out.println("---------------------------------");
     * System.out.println("    Update Movie Listing Menu    ");
     * System.out.println("---------------------------------");
     * System.out.println("Select options:");
     * System.out.println("Option 1: Show Movie Listing");
     * System.out.println("Option 2: Add Movie");
     * System.out.println("Option 3: Remove Movie");
     * System.out.println("Option 0: Return to previous menu");
     * do {
     * try {
     * choice = sc.nextInt();
     * } catch (Exception e) {
     * sc.nextLine();
     * showErrorMessage();
     * continue;
     * }
     * switch (choice) {
     * case 1:
     * showMovieListing();
     * break;
     * case 2:
     * addMovieMenu();
     * break;
     * case 3:
     * removeMovie();
     * break;
     * default:
     * showErrorMessage();
     * }
     * } while (!(0 < choice && choice <= 3));
     * }
     */

}
