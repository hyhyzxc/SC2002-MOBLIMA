package moblima.Entity;

import java.io.Serializable;

/**
 * Represents an Account.
 * Concrete base class that extends Account.
 * Concrete base class that implements Serializable interface.
 * @author Isaac Wong
 * @version 1.0
 * @since 2022-11-13
 */
public class CustomerAccount extends Account implements Serializable {
    /**
     * The serialVersionUID of this CustomerAccount.
     */
    private static final long serialVersionUID = 9091804401885457679L;

    /**
     * Creates a with given owner, username, password.
     * 
     * @param owner    This CustomerAccount's owner.
     * @param username This CustomerAccount's username.
     * @param password This CustomerAccount's password.
     */
    public CustomerAccount(Customer owner, String username, String password) {
        super(owner, username, password);
    }

}
