package moblima.UI;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;

/**
 * Handles all user IO for current Staff
 * 
 * @author
 *
 */
public class StaffUI {
    /**
     * Static Scanner object for all IO.
     */
    static final Scanner sc = new Scanner(System.in);
    /**
     * Static instance of ManagerList for entire programme.
     */
    static final Random r = new Random();
    /**
     * The StaffAccount logged into the UI.
     */
    private StaffAccount owner;
    /**
     * This StaffUI's list of managers.
     */
    private ManagerList managerList;

    /**
     * Creates new StaffUI with given account and managerList.
     * 
     * @param account     Current account logged into the UI.
     * @param managerList List of Managers.
     */
    public StaffUI(StaffAccount account, ManagerList managerList) {
        this.owner = account;
        this.managerList = managerList;
    }

    /**
     * Gets user input and adds new Movie to MovieManager movieList.
     */
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
                    newMovie = new Movie(title, synopsis, status, director, cast, movieID, 2, MovieType.REGULAR);
                    break;
                case 2:
                    newMovie = new Movie(title, synopsis, status, director, cast, movieID, 3, MovieType.BLOCKBUSTER);
                    break;
                case 3:
                    newMovie = new Movie(title, synopsis, status, director, cast, movieID, 4, MovieType.THREED);
                    break;
                default:
                    throw new InvalidInputException();
            }
            MM.addNewMovie(newMovie);
        } catch (Exception e) {
            System.out.println("Error input!");
        }

    }

    /**
     * Retrieves movieList from MovieManager and displays all movie details.
     */
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

    /**
     * Gets user input for movie title to be removed and removes it from
     * MovieManager's movieList.
     * 
     * @throws InvalidInputException
     */
    public void removeMovie() throws InvalidInputException {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        getAllMovieDetails();
        System.out.println("Choose the movie");
        int choice = sc.nextInt();
        if (choice < 1 || choice > movieList.size()) {
            throw new InvalidInputException();
        }
        MM.removeMovie(choice - 1);

    }

    /**
     * Gets user input to assign a Movie to a Cineplex.
     * 
     * @throws InvalidInputException
     */
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
            String day = (dayChoice == 1) ? "WEEKDAY"
                    : (dayChoice == 2) ? "WEEKEND" : "PUBLIC_HOLIDAY";
            sc.nextLine();

            Session session = new Session(movie, showtime, endtime, day);

            CM.addSessionToCineplex(session, cineplexChoice - 1);
            System.out.println("To terminate press 0. Else press any digit");
            cont = sc.nextInt();
        } while (cont != 0);
    }

    /**
     * Retrieves all Sessions from CinemaManager and displays them.
     */
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

    /**
     * Retrieves all Bookings from BookingManager and displays them.
     */
    public void getAllBookings() {
        BookingManager BM = managerList.getBookingManager();
        ArrayList<Booking> bookings = BM.getBookings();
        for (Booking booking : bookings) {
            booking.toTicket();
        }
    }

    /**
     * Retrieves all Movies from MovieManager and displays sorted by rating.
     */
    public void viewMoviesByRating() {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movies = MM.getSortedRating();
        System.out.println("Title (Rating):");
        for (Movie m : movies) {
            System.out.printf("%s (%f)\n", m.getTitle(), m.getAverageRatings());
        }
    }

    /**
     * Retrieves all Movies from MovieManager and displays sorted by sales.
     */
    public void viewMoviesBySales() {
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movies = MM.getSortedSales();
        System.out.println("Title (Rating):");
        for (Movie m : movies) {
            System.out.printf("%s (%f)\n", m.getTitle(), m.getNumSales());
        }
    }

    /**
     * Allows staff to change the price of the tickets of different Day Types or
     * Customer Status Type. If no existing predefined price for a new category, the
     * new criteria
     * is added. For example, if staff wants to add "DAY_A" with priceProportion of
     * 8, but currently
     * there's no "DAY_A" day type, it will be added.
     * 
     * If "DAY_A" already exists, then the priceProportion corresponding to "DAY_A"
     * will be updated.
     * 
     */
    public void configurePriceOfTickets() {
        int choice;
        System.out.println("Configure Ticket Price by:");
        System.out.println("1: Type of Day (e.g: Public Holiday, Weekday, Weekend...");
        System.out.println("2: Type of Customer (e.g: Adult, Senior Citizen, Child...");
        System.out.println("0: Back");
        choice = sc.nextInt();
        String key;
        double newPrice;
        switch (choice) {
            case 1:
                DayType d = new DayType();
                System.out.println("Pick: (1) Delete (2) Add");
                int c = sc.nextInt();
                System.out.println("Existing Keys");
                try {
                    for (String k : d.getAllExistingKeys()) {
                        System.out.println(k);
                    }
                } catch (NullPointerException e) {
                    System.out.println("There are no existing keys!, please try again");
                    return;
                }

                switch (c) {
                    case 1:
                        System.out.println("--------Delete--------");
                        System.out.println("Please choose from the available keys");
                        try {
                            d.delKey(sc.next());
                        } catch (NullPointerException e) {
                            System.out.println("Sorry, there's no such key to delete");
                            return;
                        }
                        break;
                    case 2:
                        System.out.println("--------Add--------");
                        System.out.println("You may choose from the existing keys, or input a new type");
                        key = sc.next();
                        System.out.println("Enter new price");
                        newPrice = sc.nextDouble();
                        d.setAddPriceProportion(key, newPrice);
                        System.out.println("Successfully updated!");
                        break;

                }

            case 2:
                Status s = new Status();
                System.out.println("Pick: (1) Delete (2) Add");
                int c2 = sc.nextInt();
                System.out.println("Existing Keys");
                try {
                    for (String k : s.getAllExistingKeys()) {
                        System.out.println(k);
                    }
                } catch (NullPointerException e) {
                    System.out.println("There are no existing keys!, please try again");
                    return;
                }

                switch (c2) {
                    case 1:
                        System.out.println("--------Delete--------");
                        System.out.println("Please choose from the available keys");
                        try {
                            s.delKey(sc.next());
                        } catch (NullPointerException e) {
                            System.out.println("Sorry, there's no such key to delete");
                            return;
                        }
                        break;
                    case 2:
                        System.out.println("--------Add--------");
                        System.out.println("You may choose from the existing keys, or input a new type");
                        key = sc.next();
                        System.out.println("Enter new price");
                        newPrice = sc.nextDouble();
                        s.setAddPriceProportion(key, newPrice);
                        System.out.println("Successfully updated!");
                        break;

                }
            case 0:
                return;
            default:
                showErrorMessage();
        }

    }

    /**
     * Initialises StaffUI.
     * Displays user's options and calls relevent methods.
     */
    public void init() {
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

            System.out.println("Option 8: View Movies by Ticket Sales");
            System.out.println("Option 9: Configure Price of Tickets");
            System.out.println("Option 0: Return to previous menu");

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
                        addNewMovie();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    // staffUI.main(null);
                    break;

                case 2:
                    getAllMovieDetails();
                    // staffUI.main(null);
                    break;

                case 3:
                    try {
                        removeMovie();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    // staffUI.main(null);
                    break;

                case 4:
                    try {
                        updateCineplexMovies();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    // staffUI.main(null);
                    break;

                case 5:
                    getAllSessions();
                    // staffUI.main(null);
                    break;

                case 6:
                    getAllBookings();
                    break;

                case 7:
                    viewMoviesByRating();
                    break;

                case 8:
                    viewMoviesBySales();
                    break;

                case 9:
                    configurePriceOfTickets();
                    break;

                case 0:
                    break;

                default:
                    showErrorMessage();
            }
        } while ((1 <= choice && choice <= 9));
    }

    /**
     * Static UI method to show error message.
     */
    private static void showErrorMessage() {
        System.out.println("Invalid option. Please enter a valid option. ");
    }

}
