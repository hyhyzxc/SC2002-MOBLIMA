import java.util.*;

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
            String castString = String.join(",", castList);
            System.out.println("Cast: " + castString);
            System.out.println("------------------");
        }
    }

    private static void showErrorMessage() {
        System.out.println("Invalid option. Please enter a valid option. ");
    }

    public static void main(String[] args) {
        int choice = 0;
        do {
            System.out.println("---------------------");
            System.out.println("    Customer Menu    ");
            System.out.println("---------------------");
            System.out.println("Select options:");
            System.out.println("Option 1: View All Movie Details");

            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                sc.nextLine();
                showErrorMessage();
                continue;
            }
            switch (choice) {
                case 1:
                    customerUI.getAllMovieDetails();
                    break;
                default:
                    showErrorMessage();
            }
        } while (1 <= choice && choice <= 3);
        System.out.println("exited");
    }
}
