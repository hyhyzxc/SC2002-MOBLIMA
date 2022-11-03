public class CustomerUI {

    private CustomerAccount owner;
    private ManagerList managerList = new ManagerList();

    public CustomerUI(CustomerAccount account) {
        this.owner = account;
    }

    public void getMovieList() {
        MovieManager MM = managerList.getMovieManager();

    }

    public static void main(String[] args) {
        return;
    }
}
