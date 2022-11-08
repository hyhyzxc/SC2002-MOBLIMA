package moblima.Entity;

import java.io.Serializable;

/**
 * Represent an Account
 * Abstract class that implements the Serializable interface
 */
public class Account implements Serializable {
    /**
     * The owner of this Account
     */
    private User owner;
    /**
     * The username of this Account
     */
    private String username;
    /**
     * The password of this Account
     */
    private String password;
    /**
     * The serialVersionUID of this Account
     */
    private static final long serialVersionUID = -558553967080513790L;

    /**
     * Creates a new Account with owner, username and password as null.
     */
    public Account() {
        owner = null;
        username = null;
        password = null;
    }

    /**
     * Creates a new Account with the given owner, username and password.
     * 
     * @param owner    This Account's owner.
     * @param username This Account's username.
     * @param password This Account's password.
     */
    public Account(User owner, String username, String password) {
        this.owner = owner;
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the username of this Account.
     * 
     * @return this Account's username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password of this Account.
     * 
     * @return this Account's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the owner of this Account.
     * 
     * @return this Account's owner.
     */
    public User getOwner() {
        return owner;
    }

}
