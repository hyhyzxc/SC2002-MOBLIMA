package moblima.UI;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

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
            if (statusChoice < 1 || statusChoice > 4) {
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
            System.out.println("Enter the type of Movie.");
            System.out.println("1: Regular");
            System.out.println("2: Blockbuster");
            System.out.println("3: 3D Movie");
            int movieType = sc.nextInt();
            if (movieType < 1 || movieType > 3) {
                throw new InvalidInputException();
            }
            Movie newMovie;
            switch (movieType) {
                case 1:
                    newMovie = new RegularMovie(title, synopsis, status, director, cast, movieID, 2.0);
                    break;
                case 2:
                    newMovie = new BlockbusterMovie(title, synopsis, status, director, cast, movieID, 3.0);
                    break;
                case 3:
                    newMovie = new ThreeDMovie(title, synopsis, status, director, cast, movieID, 4.0);
                    break;
                default:
                    throw new InvalidInputException();
            }
            ;
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

    public void updateCineplexMovies() throws InvalidInputException {
        CinemaManager CM = managerList.getCinemaManager();
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        ArrayList<Cineplex> cineplexList = CM.getCineplexList();
        int cont = 1;
        do {

            for (int i = 0; i < cineplexList.size(); i++) {
                System.out.printf("%d: %s\n", (i + 1), cineplexList.get(i).getLocation());
            }
            System.out.println("Select Cineplex");
            int cineplexChoice = sc.nextInt();
            if (cineplexChoice < 1 || cineplexChoice > cineplexList.size()) {
                throw new InvalidInputException();
            }

            for (int i = 0; i < movieList.size(); i++) {
                System.out.printf("%d: %s\n", (i + 1), movieList.get(i).getTitle());
            }
            System.out.println("Select Movie to add to Cineplex");
            int movieChoice = sc.nextInt();
            if (movieChoice < 1 || movieChoice > movieList.size()) {
                throw new InvalidInputException();
            }
            Movie movie = movieList.get(movieChoice - 1);

            sc.nextLine();
            System.out.println("Enter Movie Showtime in format DD/MM/YYYY h:mm a");
            String movieShowtime = sc.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
            LocalDateTime showtime = LocalDateTime.parse(movieShowtime, dtf);

            System.out.println("Enter Movie Endtime in format DD/MM/YYYY hh:mm a");
            String movieEndtime = sc.nextLine();
            DateTimeFormatter dtff = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
            LocalDateTime endtime = LocalDateTime.parse(movieEndtime, dtff);

            System.out.println("Enter Day Type");
            System.out.println("1: Weekday");
            System.out.println("2: Weekend");
            System.out.println("3: Public Holiday");
            int dayChoice = sc.nextInt();
            if (dayChoice < 1 || dayChoice > 3) {
                throw new InvalidInputException();
            }
            DayType day = (dayChoice == 1) ? DayType.WEEKDAY
                    : (dayChoice == 2) ? DayType.WEEKEND : DayType.PUBLIC_HOLIDAY;
            sc.nextLine();

            Session session = new Session(movie, showtime, endtime, day);

            CM.addSessionToCineplex(session, cineplexChoice - 1);
            System.out.println("To terminate press 0. Else press any digit");
            cont = sc.nextInt();
        } while (cont != 0);
    }

    public void getAllSessions() {
        CinemaManager CM = managerList.getCinemaManager();
        ArrayList<Session> sessions = CM.getAllSessions();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("------------------");
            System.out.println("Session No: " + (i + 1));
            System.out.println("Movie Title: " + sessions.get(i).getMovie().getTitle());
            System.out.println("Start Time: " + sessions.get(i).getSessionDateTimeStart().format(dtf));
            System.out.println("End Time: " + sessions.get(i).getSessionDateTimeEnd().format(dtf));
            System.out.println("Day Type: " + sessions.get(i).getDay());
            System.out.println("------------------");
        }
    }

    public void getAllBookings() {
        BookingManager BM = managerList.getBookingManager();
        ArrayList<Booking> bookings = BM.getBookings();
        for (Booking booking : bookings) {
            booking.toTicket();
        }
    }
    
    public void viewMoviesByRating() {
    	MovieManager MM = managerList.getMovieManager();
    	ArrayList<Movie> movies = MM.getSorted();
    	for (Movie m : movies) {
    		System.out.printf("Title: %s -------- %d", m.getTitle(), m.getAverageRatings());
    	}
    }

    public static void main(String[] args) {

        int choice = 0;

        do {
            System.out.println("------------------");
            System.out.println("    Staff Menu    ");
            System.out.println("------------------");
            System.out.println("Select options:");
            System.out.println("Option 1: Add New Movie");
            System.out.println("Option 2: Get Movie List");
            System.out.println("Option 3: Remove Movie");
            System.out.println("Option 4: Update Movie Location and Showtimes");
            System.out.println("Option 5: View All Sessions");
            System.out.println("Option 6: View All Bookings");
            System.out.println("Option 7: View Movies by Rating");
            /* TODO: Add function to configure Price */

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
                        System.out.println(e.getMessage());
                    }
                    // staffUI.main(null);
                    break;

                case 2:
                    staffUI.getAllMovieDetails();
                    // staffUI.main(null);
                    break;

                case 3:
                    try {
                        staffUI.removeMovie();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    // staffUI.main(null);
                    break;

                case 4:
                    try {
                        staffUI.updateCineplexMovies();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    // staffUI.main(null);
                    break;

                case 5:
                    staffUI.getAllSessions();
                    // staffUI.main(null);
                    break;

                case 6:
                    staffUI.getAllBookings();
                    break;
                   
                case 7:
                	staffUI.viewMoviesByRating();
                	break;
                	
                default:
                    showErrorMessage();
            }
        } while ((0 <= choice && choice <= 6));
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
