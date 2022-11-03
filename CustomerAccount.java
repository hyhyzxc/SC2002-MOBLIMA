import java.io.Serializable;

public class CustomerAccount extends Account implements Serializable {
    private Customer owner;
    private String username;
    private String password;
    private static final long serialVersionUID = 9091804401885457679L;

    public CustomerAccount(User owner, String username, String password) {
        super(owner, username, password);
    }

}
