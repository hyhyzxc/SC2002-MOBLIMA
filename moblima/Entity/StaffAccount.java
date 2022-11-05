package moblima.Entity;

import java.io.Serializable;

public class StaffAccount extends Account implements Serializable {
    private User owner;
    private String username;
    private String password;
    private ManagerList managers;
    private static final long serialVersionUID = -558553967080513790L;

    public StaffAccount(User owner, String username, String password) {
        super(owner, username, password);
    }

}
