package moblima.UI;

import java.util.*;

import javax.swing.text.html.parser.Entity;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import moblima.*;

public class LoginUI {
    private static Scanner sc = new Scanner(System.in);
    private static Random r = new Random();
    private static ManagerList managerList = new ManagerList();

    public LoginUI() {
        ;
    }

    public static void registerCustomer() throws InvalidInputException {
        CustomerManager CM = managerList.getCustomerManager();
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

        Status type = (ageGroup == 1) ? Status.STUDENT : (ageGroup == 2) ? Status.ADULT : Status.SENIOR_CITIZEN;

        int id = r.nextInt(10000);
        
        String email = "f ";
        String phoneNumber = " f";
        
        Customer newCustomer = new Customer(id, type, name, email, phoneNumber);

        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        CM.createNewAccount(newCustomer, username, password);
    }

    public static CustomerAccount loginCustomerAccount() {
        CustomerManager CM = managerList.getCustomerManager();
        System.out.println("Welcome to login page for Customers!");
        System.out.println("Please input username");
        String username = sc.next();
        System.out.println("Please enter password.");
        String password = sc.next();
        CustomerAccount account = CM.validateLoginDetails(username, password);
        return account;
    }

    public static void registerStaff() throws InvalidInputException {
        StaffManager SM = managerList.getStaffManager();
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

    public static StaffAccount loginStaffAccount() {
        StaffManager SM = managerList.getStaffManager();
        System.out.println("Welcome to login page for Staff!");
        System.out.println("Please input username");
        String username = sc.next();
        System.out.println("Please enter password.");
        String password = sc.next();
        StaffAccount account = SM.validateLoginDetails(username, password);
        return account;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do {
        	System.out.println("--- Welcome to MOBLIMA ---");
            System.out.println("1: Register as New Customer");
            System.out.println("2: Login as Customer");
            System.out.println("3: Register as New Staff");
            System.out.println("4: Login as Staff");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    try {
                    	registerCustomer();
                    } catch (InvalidInputException e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    CustomerAccount account = loginCustomerAccount();
                    if (account != null) {
                        CustomerUI CustomerAccountUI = new CustomerUI(account);
                        CustomerAccountUI.main();
                    } else {
                        System.out.println("Wrong password! Try again.");
                    }
                    break;
                case 3:
                    try {
                        registerStaff();
                    } catch (InvalidInputException e) {
                        e.getMessage();
                    }
                    break;
                case 4:
                    StaffAccount staffAccount = loginStaffAccount();
                    if (staffAccount != null) {
                        StaffUI StaffAccountUI = new StaffUI(staffAccount);
                        StaffAccountUI.main();
                    } else {
                        System.out.println("Wrong password! Try again.");
                    }
                    break;
                default:
                    break;
            }
        } while (option < 1 || option > 4);
    }
}
