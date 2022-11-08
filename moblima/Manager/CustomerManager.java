package moblima.Manager;

import java.util.*;

import moblima.Entity.Customer;
import moblima.Entity.CustomerAccount;
import moblima.Entity.User;
import moblima.Serializer.CustomerAccountSerializer;
import moblima.UI.LoginUI;

import java.io.*;

/**
 * Represents a CustomerManagers.
 * Concrete class that implements the AccountManager interface.
 * @author
 * @version 1.0
 * @since 2022-11-08
 */
public class CustomerManager implements AccountManager {
    /*
     * ArrayList consisting of valid CustomerAccounts.
     */
    private ArrayList<CustomerAccount> accountList;
    /**
     * Number of valid accounts.
     */
    private int numAccounts;

    /**
     * Creates a new CustomerManager. 
     */
    public CustomerManager() {
        CustomerAccountSerializer s = new CustomerAccountSerializer();
        accountList = s.getCustomerAccounts("CustomerAccountData.ser");
        if (accountList == null) {
            accountList = new ArrayList<CustomerAccount>();
        }
        numAccounts = accountList.size();
    }

    /**
     * Creates a new account for a customer with the given owner, username, password.
     * @param owner This CustomerAccount's owner.
     * @param username This CustomerAccount's username.
     * @param password This CustomerAccount's password.
     */
    public void createNewAccount(User owner, String username, String password) {
        CustomerAccountSerializer s = new CustomerAccountSerializer();
        CustomerAccount newAccount = new CustomerAccount((Customer) owner, username, password);
        accountList.add(newAccount);
        s.saveCustomerAccounts(accountList, "CustomerAccountData.ser");

        System.out.println("Customer Account Successfully Created.");
    }

    /**
     * Verifies the validity of the given username and password.
     * @param username This CustomerAccount's username.
     * @param password This CustomerAccount's password.
     * @return an Account if given details are valid, else null.
     */
    public CustomerAccount validateLoginDetails(String username, String password) {
        CustomerAccountSerializer s = new CustomerAccountSerializer();
        accountList = s.getCustomerAccounts("CustomerAccountData.ser");
        for (int i = 0; i < accountList.size(); i++) {
            String accountUN = accountList.get(i).getUsername();
            String accountPW = accountList.get(i).getPassword();
            System.out.println(accountUN + " " + accountPW);
            if (accountUN.equals(username) && accountPW.equals(password)) {
                return accountList.get(i);
            }
        }
        return null;
    }

}
