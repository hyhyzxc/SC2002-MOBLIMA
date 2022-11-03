import java.io.Serializable;

public abstract class Account implements Serializable {
    private User owner;
    private String username;
    private String password;
    private static final long serialVersionUID = -558553967080513790L;

    public Account() {
        owner = null;
        username = null;
        password = null;
    }

    public Account(User owner, String username, String password) {
        this.owner = owner;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User getOwner() {
        return owner;
    }
}
