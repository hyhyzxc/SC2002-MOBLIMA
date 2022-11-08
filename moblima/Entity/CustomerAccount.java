package moblima.Entity;

import java.io.Serializable;

/**
 * Represents an Account. 
 * Concrete base class that extends Account.
 * Concrete base class that implements Serializable interface. 
 */
public class CustomerAccount extends Account implements Serializable {
    /**
     * This owner of this CustomerAccount.
     */
    private Customer owner;
    /**
     * The username of this CustomerAccount.
     */
    private String username;
    /**
     * The password of this CustomerAccount.
     */
    private String password;
    /**
     * The serialVersionUID of this CustomerAccount.
     */
    private static final long serialVersionUID = 9091804401885457679L;
    /**
     * Creates a new CustomerAccount with given owner, username, password.
     * @param owner This CustomerAccount's owner.
     * @param username This CustomerAccount's username.
     * @param password This CustomerAccount's password.
     */
    public CustomerAccount(User owner, String username, String password) {
        super(owner, username, password);
    }

}
