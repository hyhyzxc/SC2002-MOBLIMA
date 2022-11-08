package moblima.Entity;

import java.io.Serializable;

/**
 * Represents the Staff Account that stores a Staff.
 * Subclass of Account.
 * Implements Serializable.
 */
public class StaffAccount extends Account implements Serializable {
	/**
     * The serialVersionUID of this Account.
     */
    private static final long serialVersionUID = -558553967080513790L;

    /**
     * Creates a new StaffAccount with given User owner, username and password
     * @param owner User of this account.
     * @param username Username of this account.
     * @param password Password of this account.
     */
    public StaffAccount(User owner, String username, String password) {
        super(owner, username, password);
    }

}
