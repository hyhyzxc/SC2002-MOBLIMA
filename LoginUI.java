import java.util.*;

public class LoginUI {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    private ManagerList managerList = new ManagerList();

    public void registerCustomer() throws InvalidInputException {
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

        Customer newCustomer = new Customer(id, type, name);

        System.out.println("Enter your username: ");
        String username = sc.next();
        System.out.println("Enter your password: ");
        String password = sc.next();
        CM.createNewAccount(newCustomer, username, password);
    }

    public CustomerAccount loginCustomerAccount() {
        CustomerManager CM = managerList.getCustomerManager();
        System.out.println("Welcome to login page for Customers!");
        System.out.println("Please input username");
        String username = sc.next();
        System.out.println("Please enter password.");
        String password = sc.next();
        CustomerAccount account = CM.validateLoginDetails(username, password);
        return account;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("--- Welcome to MOBLIMA ---");
        System.out.println("1: Register as New Customer");
        System.out.println("2: Login as Customer");
        int option = sc.nextInt();
        LoginUI newUI = new LoginUI();

        switch (option) {
            case 1:
                try {
                    newUI.registerCustomer();
                } catch (InvalidInputException e) {
                    e.getMessage();
                    newUI.main(null);
                }
                break;
            case 2:
                CustomerAccount account = newUI.loginCustomerAccount();
                if (account != null) {
                    CustomerUI CustomerAccountUI = new CustomerUI(account);
                    CustomerAccountUI.main(null);
                } else {
                    System.out.println("Wrong password! Try again.");
                    newUI.main(null);
                }
                break;
            default:
                break;
        }

    }
}
