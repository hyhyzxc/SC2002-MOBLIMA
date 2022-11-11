package moblima.Entity;

import java.io.Serializable;

/**
 * Represents a user that logs into MOBLIMA.
 * Concrete class that implements Serializable.
 */
public abstract class User implements Serializable {
    /**
     * The ID of the User.
     */
    private int userID;
    /**
     * The name of the User.
     */
    private String name;
    /**
     * The serialization version UID of User Class.
     */
    private static final long serialVersionUID = 841221869724731376L;

    /**
     * Creates a new User with the given name and ID.
     * 
     * @param userID This User's ID.
     * @param name   This User's name.
     */
    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    /**
     * Gets this User's ID.
     * 
     * @return this User's ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Gets this User's Name.
     * 
     * @return this User's name.
     */
    public String getName() {
        return name;
    }

    public abstract String getStatus();
}
