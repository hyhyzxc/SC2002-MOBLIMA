import java.io.Serializable;

public class CustomerAccount implements Serializable {
    private Customer owner;
    private String username;
    private String password;
    private ManagerList managers;

    public CustomerAccount(Customer owner, String username, String password) {
        this.owner = owner;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public Customer owner() {
        return owner;
    }

    public String getPassword() {
        return password;
    }
}
