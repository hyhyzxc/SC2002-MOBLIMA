package moblima.UI;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;

/**
 * Handles all user IO for current Staff
 * 
 * @author Amabel Lee
 * @version 1.0
 * @since 2022-11-11
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
     * @throws InvalidInputException Raises exception when input is invalid.
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
                    newMovie = new RegularMovie(title, synopsis, status, director, cast, movieID);
                    break;
                case 2:
                    newMovie = new BlockbusterMovie(title, synopsis, status, director, cast, movieID);
                    break;
                case 3:
                    newMovie = new ThreeDMovie(title, synopsis, status, director, cast, movieID);
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
     * Gets user input for movie title to be removed and removes it from
     * MovieManager's movieList.
     * 
     * @throws InvalidInputException Raises exception when input is invalid
     */
    public void removeMovie() throws InvalidInputException {
        MovieManager MM = managerList.getMovieManager();
        CinemaManager CM = managerList.getCinemaManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        getAllMovieDetails();
        System.out.println("Choose the movie");
        int choice = sc.nextInt();
        if (choice < 1 || choice > movieList.size()) {
            throw new InvalidInputException();
        }
        CM.removeAllSessionsFromCineplexes(movieList.get(choice - 1).getTitle());
        MM.removeMovie(choice - 1);

    }

    /**
     * Gets user input to assign a Movie to a Cineplex.
     * 
     * @throws InvalidInputException Raises exception when input is invalid
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
            if (movie.getStatus().equals(ShowingStatus.COMING_SOON)
                    || movie.getStatus().equals(ShowingStatus.END_OF_SHOWING)) {
                System.out.println("Movie not available to book.");
                return;
            }

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
            DayType dt = new DayType();
            dt.printDayType();
            int dayChoice = sc.nextInt();
            if (dayChoice < 1 || dayChoice > dt.getAllExistingKeys().size()) {
                throw new InvalidInputException();
            }
            String day = dt.getAllExistingKeys().get(dayChoice - 1);
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
        DayType dt = new DayType();
        LinkedHashMap<String, ArrayList<Session>> sessionsMap = CM.getAllSessions();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
        if (sessionsMap.size() == 0) {
            System.out.println("------------------");
            System.out.println("No available sessions!");
            System.out.println("------------------");
            return;
        }

        ArrayList<String> keys = new ArrayList<String>(sessionsMap.keySet());
        for (int i = 0; i < sessionsMap.size(); i++) {
            String cineplexName = keys.get(i);
            ArrayList<Session> sessions = sessionsMap.get(cineplexName);
            System.out.printf("(%d) Cineplex Name: %s \n", i + 1, cineplexName);
            if (sessions == null)
                continue;
            for (int j = 0; j < sessions.size(); j++) {
                Session session = sessions.get(j);
                System.out.println("------------------");
                System.out.println("Session No: " + (j + 1));
                System.out.println("Movie Title: " + session.getMovie().getTitle());
                System.out.println("Start Time: " + session.getSessionDateTimeStart().format(dtf));
                System.out.println("End Time: " + session.getSessionDateTimeEnd().format(dtf));
                System.out.println("Day Type: " + session.getDay());
                System.out.println("Day Price Proportion: " + dt.getDayList().get(session.getDay()));
                System.out.println("------------------");
            }
        }

        System.out.printf("(1) Remove a Session\n(0) Back\n");
        int c = sc.nextInt();
        switch (c) {
            case 1:
                System.out.println("Enter the Cineplex No. to delete from");
                int cineplexNum = sc.nextInt();
                System.out.println("Enter the session number to delete: ");
                int seshNum = sc.nextInt();
                Session toRemove = sessionsMap.get(keys.get(cineplexNum - 1)).get(seshNum - 1);
                CM.removeSessionFromCineplex(toRemove, cineplexNum - 1);
                break;

            case 0:
                return;
            default:
                System.out.println("Invalid Choice");
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
     * Displays a list of movies sorted by a movie's average rating. Higher rating
     * indicates higher rank and thus will be displayed first.
     */
    public void viewMoviesByRating() {
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
            System.out.println("------------------------------------");
            System.out.println("Rank: " + i++);
            System.out.println("Movie: " + movieName);
            System.out.println("Rating: " + hm.get(movieName));
            System.out.println("------------------------------------");
        }
    }

    /**
     * Displays a list of movies sorted by a movie's number of sales. Higher number
     * of sales indicates higher rank and thus will be displayed first.
     */
    public void viewMoviesBySales() {
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
            boolean found = false;
            for (Movie m : managerList.getMovieManager().getMovieList()) {
                if (movieName.equals(m.getTitle()))
                    found = true;
            }
            if (found) {
                System.out.println("------------------------------------");
                System.out.println("------------------------------------");
                System.out.println("Rank: " + i++);
                System.out.println("Movie: " + movieName);
                System.out.println("Num of Sales: " + hm.get(movieName));
                System.out.println("------------------------------------");
            } else
                continue;
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
        System.out.println("3: View Configurations");
        System.out.println("0: Back");
        choice = sc.nextInt();
        String key;
        double newPrice;
        switch (choice) {
            case 1:
                DayType d = new DayType();
                System.out.println("Pick: (1) Delete (2) Add (0) Back");
                int c = sc.nextInt();
                System.out.println("Existing Keys");
                try {
                    for (String k : d.getAllExistingKeys()) {
                        System.out.println(k + " " + d.getDayList().get(k));
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
                            String s = sc.next();
                            d.delKey(s);
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
                    case 0:
                        return;
                    default:
                        showErrorMessage();
                        return;

                }
                break;
            case 2:
                Status s = new Status();
                System.out.println("Pick: (1) Delete (2) Add (0) Back");
                int c2 = sc.nextInt();
                System.out.println("Existing Keys");
                try {
                    for (String name : s.getAllExistingKeys()) {
                        System.out.println(name + " " + s.getStatusList().get(name));
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
                            String s2 = sc.next();
                            s.delKey(s2);
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
                    case 0:
                        return;
                    default:
                        showErrorMessage();
                        return;

                }
                break;
            case 3:
                DayType dt = new DayType();
                dt.printDayType();
                Status st = new Status();
                st.printStatus();
                break;

            case 0:
                return;
            default:
                showErrorMessage();
                return;
        }

    }

    /**
     * Allows Staff to change the visibility of customer when viewing movies by a
     * filter.
     */
    public void configureCustomerVisibility() {
        System.out.println("Configure Customer Visibility");
        System.out.println("Which would you like to change?");
        StaffConfigs staffc = new StaffConfigs();
        staffc.printCurrentConfigs();
        String choice = sc.next();
        System.out.println("Enter boolean value: true/false");
        boolean newBool = sc.nextBoolean();
        staffc.changeConfigs(choice, newBool);
        return;
    }
 
    /**
     * Allows Staff to configure Movie details.
     * @param ID ID of movie to configured.
     * @throws InvalidInputException Raises exception when input is invalid
     */
    public void updateMovieDetails(int ID) throws InvalidInputException {
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
                    newMovie = new RegularMovie(title, synopsis, status, director, cast, movieID);
                    break;
                case 2:
                    newMovie = new BlockbusterMovie(title, synopsis, status, director, cast, movieID);
                    break;
                case 3:
                    newMovie = new ThreeDMovie(title, synopsis, status, director, cast, movieID);
                    break;
                default:
                    throw new InvalidInputException();

            }
            MM.updateMovie(ID, newMovie);
        } catch (Exception e) {
            System.out.println("Error input!");
            System.out.println(e.getMessage());
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
            System.out.println("Option 4: Update Movie Details");
            System.out.println("Option 5: Add Movie Location and Showtimes");
            System.out.println("Option 6: View All Sessions");
            System.out.println("Option 7: View All Bookings");
            System.out.println("Option 8: View Movies by Rating");
            System.out.println("Option 9: View Movies by Ticket Sales");
            System.out.println("Option 10: Configure Price of Tickets");
            System.out.println("Option 11: Configure Customer Visibility");
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
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 2:
                    getAllMovieDetails();
                    // staffUI.main(null);
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 3:
                    try {
                        removeMovie();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    // staffUI.main(null);
                    break;
                case 4:
                    try {
                        getAllMovieDetails();
                        System.out.println("Choose the movie to update.");
                        int movieID = sc.nextInt();
                        sc.nextLine();
                        updateMovieDetails(movieID);
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 5:
                    try {
                        updateCineplexMovies();
                    } catch (InvalidInputException e) {
                        System.out.println(e.getMessage());
                    }
                    // staffUI.main(null);
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 6:
                    getAllSessions();
                    // staffUI.main(null);
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 7:
                    getAllBookings();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 8:
                    viewMoviesByRating();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 9:
                    viewMoviesBySales();
                    System.out.println(
                            "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 10:
                    configurePriceOfTickets();
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------------------------------");
                    break;

                case 11:
                    configureCustomerVisibility();
                    System.out.println(
                            "-----------------------------------------------------------------------------------------------------------------------------");
                    break;
                case 0:
                    break;

                default:
                    showErrorMessage();
            }
        } while ((1 <= choice && choice <= 11));
    }

    /**
     * Static UI method to show error message.
     */
    private static void showErrorMessage() {
        System.out.println("Invalid option. Please enter a valid option. ");
    }

}
