package moblima.UI;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import java.util.*;

/**
 * Handles all user IO for booking purposes.
 * 
 * @author Amabel Lee
 * @version 1.0
 * @since 2022-11-11
 *
 */
public class BookingUI {
    /**
     * The owner of the customer account that is making the booking.
     */
    private static CustomerAccount owner;
    /**
     * List of all managers.
     */
    private static ManagerList managerList;
    /**
     * Static Scanner object for IO.
     */
    static final Scanner sc = new Scanner(System.in);

    /**
     * Creates a new BookingUI with the specified owner.
     * 
     * @param owner This BookingUI's owner.
     */
    public BookingUI(CustomerAccount owner, ManagerList managerList) {
        this.owner = owner;
        this.managerList = managerList;
    }

    /**
     * Creates a booking.
     * A booking will consist of a cineplex number, date and time of a movie, cinema
     * number, seat number.
     * A booking with settle the payment process and collect the owner's validated
     * email and handphone number.
     * 
     * @throws InvalidInputException
     * @throws InvalidEmailException
     * @throws InvalidPhoneNoException
     */
    public static void viewSeatAvailability() throws InvalidInputException {
        CinemaManager CM = managerList.getCinemaManager();
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        ArrayList<Cineplex> cineplexList = CM.getCineplexList();

        for (int i = 0; i < cineplexList.size(); i++) {
            System.out.printf("%d: %s\n", (i + 1), cineplexList.get(i).getLocation());
        }
        System.out.println("Select Cineplex");
        int cineplexChoice = sc.nextInt();
        if (cineplexChoice < 1 || cineplexChoice > cineplexList.size()) {
            throw new InvalidInputException();
        }
        Cineplex cineplexChosen = cineplexList.get(cineplexChoice - 1);

        ArrayList<Session> sessions = cineplexList.get(cineplexChoice - 1).getAvailableSessions();
        if (sessions.size() == 0) {
            System.out.println("No sessions available.");
            return;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("------------------");
            System.out.println("Session No: " + (i + 1));
            System.out.println("Movie Title: " + sessions.get(i).getMovie().getTitle());
            System.out.println("Start Time: " + sessions.get(i).getSessionDateTimeStart().format(dtf));
            System.out.println("End Time: " + sessions.get(i).getSessionDateTimeEnd().format(dtf));
            System.out.println("------------------");
        }
        System.out.println("Enter Session Number to Book.");
        int sessionChoice = sc.nextInt();
        if (sessionChoice < 1 || sessionChoice > sessions.size()) {
            throw new InvalidInputException();
        }
        Session sessionChosen = sessions.get(sessionChoice - 1);

        ArrayList<Cinema> theatres = cineplexList.get(cineplexChoice - 1).getTheatres();
        for (int i = 0; i < theatres.size(); i++) {
            System.out.println("Cinema No: " + (i + 1) + theatres.get(i).getCinemaType().getName());
        }
        System.out.println("Enter Cinema Number to Book.");
        int cinemaChoice = sc.nextInt();
        if (cinemaChoice < 1 || cinemaChoice > theatres.size()) {
            throw new InvalidInputException();
        }

        Cinema cinemaChosen = theatres.get(cinemaChoice - 1);
        ArrayList<Seat> seats = cinemaChosen.getSeats();
        for (int i = 0; i < seats.size(); i++) {
            if (i % 10 == 0) {
                if (i != 0)
                    System.out.println();
                else {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println();
                    System.out.println("                        Screen                      ");
                    System.out.println();
                    System.out.println("-----------------------------------------------------------");
                }
                if (i != 20)
                    System.out.print("|             |");
                else
                    System.out.print("|    Aisle    |");
            }
            if (seats.get(i).isOccupied()) {
                System.out.print("X|");
            } else {
                if (i >= 10)
                    System.out.print((i + 1) + "|");
                else
                    System.out.print(" " + (i + 1) + "|");

            }
            if (i % 10 == 9) {
                if (i != 29)
                    System.out.print("             |");
                else {
                    System.out.print("    Aisle    |");
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.printf("-------------------------------------%n");
        System.out.printf("            Seat Types      %n");
        System.out.printf("-------------------------------------%n");
        System.out.printf("| %-10s | %-20s |%n", "1-20: ", "Regular Seat");
        System.out.printf("| %-10s | %-20s |%n", "21-30: ", "Couple Seat");
        System.out.printf("| %-10s | %-20s |%n", "31-40: ", "Elite Seat");
        System.out.printf("| %-10s | %-20s |%n", "41-50: ", "Ultima Seat");

    }

    /**
     * Gets user input to make new Booking.
     * 
     * @throws InvalidInputException
     * @throws InvalidEmailException
     * @throws InvalidPhoneNoException
     */
    private static void makeBooking() throws InvalidInputException, InvalidEmailException, InvalidPhoneNoException {
        CinemaManager CM = managerList.getCinemaManager();
        MovieManager MM = managerList.getMovieManager();
        ArrayList<Movie> movieList = MM.getMovieList();
        ArrayList<Cineplex> cineplexList = CM.getCineplexList();

        for (int i = 0; i < cineplexList.size(); i++) {
            System.out.printf("%d: %s\n", (i + 1), cineplexList.get(i).getLocation());
        }
        System.out.println("Select Cineplex");
        int cineplexChoice = sc.nextInt();
        if (cineplexChoice < 1 || cineplexChoice > cineplexList.size()) {
            throw new InvalidInputException();
        }
        Cineplex cineplexChosen = cineplexList.get(cineplexChoice - 1);

        ArrayList<Session> sessions = cineplexList.get(cineplexChoice - 1).getAvailableSessions();
        if (sessions.size() == 0) {
            System.out.println("No sessions available.");
            return;
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy h:mm a");
        for (int i = 0; i < sessions.size(); i++) {
            System.out.println("------------------");
            System.out.println("Session No: " + (i + 1));
            System.out.println("Movie Title: " + sessions.get(i).getMovie().getTitle());
            System.out.println("Start Time: " + sessions.get(i).getSessionDateTimeStart().format(dtf));
            System.out.println("End Time: " + sessions.get(i).getSessionDateTimeEnd().format(dtf));
            System.out.println("------------------");
        }
        System.out.println("Enter Session Number to Book.");
        int sessionChoice = sc.nextInt();
        if (sessionChoice < 1 || sessionChoice > sessions.size()) {
            throw new InvalidInputException();
        }
        Session sessionChosen = sessions.get(sessionChoice - 1);

        ArrayList<Cinema> theatres = cineplexList.get(cineplexChoice - 1).getTheatres();
        for (int i = 0; i < theatres.size(); i++) {
            System.out.println("Cinema No: " + (i + 1) + theatres.get(i).getCinemaType().getName());
        }
        System.out.println("Enter Cinema Number to Book.");
        int cinemaChoice = sc.nextInt();
        if (cinemaChoice < 1 || cinemaChoice > theatres.size()) {
            throw new InvalidInputException();
        }

        Cinema cinemaChosen = theatres.get(cinemaChoice - 1);
        ArrayList<Seat> seats = cinemaChosen.getSeats();
        for (int i = 0; i < seats.size(); i++) {
            if (i % 10 == 0) {
                if (i != 0)
                    System.out.println();
                else {
                    System.out.println("-----------------------------------------------------------");
                    System.out.println();
                    System.out.println("                        Screen                      ");
                    System.out.println();
                    System.out.println("-----------------------------------------------------------");
                }
                if (i != 20)
                    System.out.print("|             |");
                else
                    System.out.print("|    Aisle    |");
            }
            if (seats.get(i).isOccupied()) {
                System.out.print("X|");
            } else {
                if (i >= 10)
                    System.out.print((i + 1) + "|");
                else
                    System.out.print(" " + (i + 1) + "|");

            }
            if (i % 10 == 9) {
                if (i != 29)
                    System.out.print("             |");
                else {
                    System.out.print("    Aisle    |");
                }
            }
        }
        System.out.println();
        System.out.println();
        System.out.printf("-------------------------------------%n");
        System.out.printf("            Seat Types      %n");
        System.out.printf("-------------------------------------%n");
        System.out.printf("| %-10s | %-20s |%n", "1-20: ", "Regular Seat");
        System.out.printf("| %-10s | %-20s |%n", "21-30: ", "Couple Seat");
        System.out.printf("| %-10s | %-20s |%n", "31-40: ", "Elite Seat");
        System.out.printf("| %-10s | %-20s |%n", "41-50: ", "Ultima Seat");

        System.out.println("Enter Seat Number to Book.");
        int seatChoice = sc.nextInt();
        if (seatChoice < 1 || seatChoice > seats.size()) {
            throw new InvalidInputException();
        }
        Seat seatChosen = seats.get(seatChoice - 1);
        if (seatChosen.isOccupied()) {
            System.out.println("Seat already occupied.");
            return;
        }
        System.out.println("Enter 1 to make Payment, 0 to return to menu.");

        /* TODO: Ask user for Email and mobile number before payment */
        /* TODO: Print price before payment */
        int payment = sc.nextInt();
        if (payment == 0) {
            return;
        } else {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
            String datetime = now.format(df).substring(0, 14).replace(" ", "").replace(":", "");
            // System.out.println("this is datetime" + datetime);
            String TID = cinemaChosen.getCinemaID() + datetime;
            CM.reserveSeat(seatChosen);
            // System.out.println("Owner " + owner);
            Booking newBooking = new Booking(TID, owner, sessionChosen, cineplexChosen, seatChosen, cinemaChosen);
            BookingManager BM = managerList.getBookingManager();
            System.out.println("------------- Confirm Payment ------------");

            PriceManager PM = managerList.getPriceManager();
            System.out.println("Movie: " + sessionChosen.getMovie().getTitle());
            System.out.println("Start DateTime: " + sessionChosen.getSessionDateTimeStart().toString());
            System.out.println("End DateTime: " + sessionChosen.getSessionDateTimeEnd().toString());
            System.out.println("The total price is: " + PM.calcPrice(newBooking));
            System.out.println("1: Proceed, 0: return to menu.");
            int proceed = sc.nextInt();
            if (proceed == 0) {
                return;
            }
            sc.nextLine();
            System.out.println("Enter email: ");
            String email = sc.nextLine();
            char[] emailArray = email.toCharArray();
            boolean valid = false;
            for (int i = 0; i < email.length(); i++) {
                if (emailArray[i] == '@') {
                    for (int j = i; j < email.length(); j++) {
                        if (emailArray[j] == '.') {
                            valid = true;
                            break;
                        }
                    }
                }
            }
            if (valid == false) {
                throw new InvalidEmailException();
            }

            System.out.println("Enter mobile number: ");
            String mobile = sc.nextLine();
            if (mobile.length() != 8 && mobile.length() != 9) {
                throw new InvalidPhoneNoException();
            }

            BM.addNewBooking(newBooking);
            System.out.println("Here is the receipt.");
            newBooking.toTicket();
            System.out.printf("| %-20s | %-20s |%n", "Price: ", PM.calcPrice(newBooking));
            System.out.println(
                    "Receipt has been sent to your email and sms, please show them to the staff at movie entrance.");

        }
    }

    /**
     * Initialises BookingUI.
     * Displays the outline of the main menu and calls makeBooking()
     * 
     * @param args
     */
    public void init() {

        System.out.println("------------------");
        System.out.println("   Booking Menu   ");
        try {
            makeBooking();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            init();
            return;
        } catch (InvalidEmailException ee) {
            System.out.println(ee.getMessage());
        } catch (InvalidPhoneNoException eee) {
            System.out.println(eee.getMessage());
        }
        return;
    }
}
