package moblima.Manager;

import moblima.Entity.Account;
import moblima.Entity.User;
/**
 * Represents an AccountManager.
 * Interface class implemented by CustomerManager and StaffManager.
 * Consist of abstract methods that allows users to register a new account and verify their log in details. 
 * @author Amabel Lim
 * @version 1.0
 * @since 2022-11-08
 */
public interface AccountManager {
    /**
     * Creates a new account with given owner, username and password.
     * @param owner This AccountManager's owner.
     * @param username This AccountManager's username.
     * @param password This AccountManager's password.
     */
    public abstract void createNewAccount(User owner, String username, String password);

    /**
     * Verifies the validity of the given username and password.
     * @param username This AccountManager's username.
     * @param password This AccountManager's password.
     * @return an Account if given details are valid, else null.
     */
    public abstract Account validateLoginDetails(String username, String password);
}
