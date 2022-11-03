import java.io.Serializable;

public class ManagerList {
    private CustomerManager customerManager;
    private MovieManager movieManager;
    private StaffManager staffManager;

    public ManagerList() {
        this.customerManager = new CustomerManager();
        this.movieManager = new MovieManager();
        this.staffManager = new StaffManager();
    }

    public CustomerManager getCustomerManager() {
        return customerManager;
    }

    public MovieManager getMovieManager() {
        return movieManager;
    }

    public StaffManager getStaffManager() {
        return staffManager;
    }
}
