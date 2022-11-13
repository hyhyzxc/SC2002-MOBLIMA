package moblima.UI;

import java.util.*;

import javax.swing.event.SwingPropertyChangeSupport;
import javax.swing.text.html.parser.Entity;

import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;

/**
 * Main class of entire programme.
 * Initialises Login Menu for the user.
 * 
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-11
 *
 */
public class LoginUI {
    /**
     * Static Scanner object for user IO.
     */
    private static Scanner sc = new Scanner(System.in);
    /**
     * Static Random object for ID generation.
     */
    private static Random r = new Random();
    /**
     * Static instance of ManagerList for entire programme.
     */
    private static ManagerList managerList = new ManagerList();

    /**
     * Gets valid user input for Customer and registers them as a new Customer.
     * 
     * @throws InvalidInputException Raises exception when input is invalid
     */
    public static void registerCustomer() throws InvalidInputException {
        AccountManager CM = managerList.getCustomerManager();
        System.out.println("Welcome to registration page for new Customer!");
        System.out.println("Please input name: ");
        String name;
        int ageGroup = 0;

        name = sc.next();

        System.out.println("Please input your age group. 1: Student, 2: Adult, 3: Senior Citizen");

        ageGroup = sc.nextInt();
        if (ageGroup < 1 || ageGroup > 3) {
            throw new InvalidInputException("Invalid Age Group input");
        }

        String type = (ageGroup == 1) ? "STUDENT" : (ageGroup == 2) ? "ADULT" : "SENIOR_CITIZEN";

        int id = r.nextInt(10000);

        Customer newCustomer = new Customer(id, type, name, "", "");

        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        CM.createNewAccount(newCustomer, username, password);
    }

    /**
     * Gets valid username and password from the user and logs them into their
     * CustomerAccount if valid.
     * 
     * @return Customer account that just logged in.
     */
    public static CustomerAccount loginCustomerAccount() {
        AccountManager CM = managerList.getCustomerManager();
        System.out.println("Welcome to login page for Customers!");
        System.out.println("Please input username");
        String username = sc.next();
        System.out.println("Please enter password.");
        String password = sc.next();
        CustomerAccount account = (CustomerAccount) CM.validateLoginDetails(username, password);
        return account;
    }

    /**
     * Gets valid user input for Staff and registers them as a new Staff.
     * @throws InvalidInputException Raises exception when input is invalid
     */
    public static void registerStaff() throws InvalidInputException {
        AccountManager SM = managerList.getStaffManager();
        System.out.println("Welcome to registration page for new Staff!");
        System.out.println("Please input name: ");
        String name;

        name = sc.next();

        int id = r.nextInt(10000);

        Staff newStaff = new Staff(id, name);

        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        SM.createNewAccount(newStaff, username, password);

    }

    /**
     * Gets valid username and password from the user and logs them into their
     * StaffAccount if valid.
     * 
     * @return The StaffAccount retrieved.
     */
    public static StaffAccount loginStaffAccount() {
        AccountManager SM = managerList.getStaffManager();
        System.out.println("Welcome to login page for Staff!");
        System.out.println("Please input username");
        String username = sc.next();
        System.out.println("Please enter password.");
        String password = sc.next();
        StaffAccount account = (StaffAccount) SM.validateLoginDetails(username, password);
        return account;
    }

    /**
     * Displays error message if input is invalid.
     */
    private static void showErrorMessage() {
        System.out.println("Invalid option. Please enter a valid option. ");
    }

    /**
     * Main method for programme.
     * Initialises login menu.
     * Calls other UI init functions to transfer control flow.
     * 
     * @param args
     * @throws InvalidEmailException Raises exception when email is invalid
     * @throws InvalidPhoneNoException Raises exception when phone number is invalid
     */
    public static void main(String[] args) throws InvalidEmailException, InvalidPhoneNoException {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("--- Welcome to MOBLIMA ---");
            System.out.println("1: Register as New Customer");
            System.out.println("2: Login as Customer");
            System.out.println("3: Register as New Staff");
            System.out.println("4: Login as Staff");
            System.out.println("Enter 0 to exit");
            option = sc.nextInt();

            switch (option) {
                case 0:
                    break;
                case 1:
                    try {
                        registerCustomer();
                    } catch (InvalidInputException e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    CustomerAccount account;
                    while (true) {
                        account = loginCustomerAccount();
                        if (account == null) {
                            System.out.println(
                                    "Wrong password! Try again? Enter 0 to terminate, otherwise enter any character.");
                            int tryagain = sc.nextInt();
                            if (tryagain == 0) {
                                return;
                            }
                        } else
                            break;
                    }
                    CustomerUI CustomerAccountUI = new CustomerUI(account, managerList);
                    CustomerAccountUI.init();
                    break;
                case 3:
                    try {
                        registerStaff();
                    } catch (InvalidInputException e) {
                        e.getMessage();
                    }
                    break;
                case 4:
                    StaffAccount staffAccount;
                    while (true) {
                        staffAccount = loginStaffAccount();
                        if (staffAccount == null) {
                            System.out.println(
                                    "Wrong password! Try again? Enter 0 to terminate, otherwise enter any character.");
                            int tryy = sc.nextInt();
                            if (tryy == 0) {
                                return;
                            }
                        } else
                            break;
                    }
                    StaffUI StaffAccountUI = new StaffUI(staffAccount, managerList);
                    StaffAccountUI.init();
                    break;
                default:
                    showErrorMessage();
                    break;
            }
        } while (option != 0);
    }
}
