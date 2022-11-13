package moblima.Manager;

import java.util.*;

import moblima.Entity.StaffAccount;
import moblima.Entity.User;
import moblima.Serializer.StaffAccountSerializer;
import moblima.UI.LoginUI;

/**
 * Represents a StaffManager.
 * Concrete class that implements the AccountManager interface.
 * 
 * @author Darren Lee
 * @version 1.0
 * @since 2022-11-11
 */
public class StaffManager implements AccountManager {

    /**
     * ArrayList consisting of valid StaffAccounts.
     */
    private ArrayList<StaffAccount> accountList;

    /**
     * Number of valid accounts.
     */
    private int numAccounts;

    /**
     * Creates a new StaffManager.
     */
    public StaffManager() {
        StaffAccountSerializer s = new StaffAccountSerializer();
        accountList = StaffAccountSerializer.getStaffAccounts("StaffAccountData.ser");
        if (accountList == null) {
            accountList = new ArrayList<StaffAccount>();
        }
        numAccounts = accountList.size();
    }

    /**
     * Creates a new account for a staff with the given owner, username,
     * password.
     * If a valid newAccount of StaffAccount type is created, append newAccount
     * to accountList.
     * Displays a message of a successful confirmation.
     * 
     * @param owner    this StaffAccount's owner.
     * @param username this CustomerAccount's username.
     * @param password this CustomerAccount's password.
     */
    public void createNewAccount(User owner, String username, String password) {
        StaffAccount newAccount = new StaffAccount(owner, username, password);
        accountList.add(newAccount);
        StaffAccountSerializer s = new StaffAccountSerializer();
        s.saveStaffAccounts(accountList, "StaffAccountData.ser");
        System.out.println("Staff Account Successfully Created.");

    }

    /**
     * Verifies the validity of the given username and password.
     * Iterates through the accountList and search for an entry corresponding to the
     * given username and password.
     * 
     * @param username this StaffAccount's username.
     * @param password this StaffAccount's password.
     * @return an Account if given details are valid, else null.
     */
    public StaffAccount validateLoginDetails(String username, String password) {
        StaffAccountSerializer s = new StaffAccountSerializer();
        accountList = s.getStaffAccounts("StaffAccountData.ser");
        for (int i = 0; i < accountList.size(); i++) {
            String accountUN = accountList.get(i).getUsername();
            String accountPW = accountList.get(i).getPassword();
            // System.out.println(accountUN + " " + accountPW);
            if (accountUN.equals(username) && accountPW.equals(password)) {
                return accountList.get(i);
            }
        }
        return null;
    }
}
