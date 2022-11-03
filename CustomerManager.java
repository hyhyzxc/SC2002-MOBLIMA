import java.util.*;
import java.io.*;

public class CustomerManager implements AccountManager {
    private ArrayList<CustomerAccount> accountList;
    private int numAccounts;

    public CustomerManager() {
        CustomerAccountSerializer s = new CustomerAccountSerializer();
        accountList = s.getCustomerAccounts("CustomerAccountData.ser");
        if (accountList == null) {
            accountList = new ArrayList<CustomerAccount>();
        }
        numAccounts = accountList.size();
    }

    public void createNewAccount(User owner, String username, String password) {
        CustomerAccountSerializer s = new CustomerAccountSerializer();
        CustomerAccount newAccount = new CustomerAccount((Customer) owner, username, password);
        accountList.add(newAccount);
        s.saveCustomerAccounts(accountList, "CustomerAccountData.ser");

        System.out.println("Customer Account Successfully Created.");
        LoginUI.main(null);
    }

    public CustomerAccount validateLoginDetails(String username, String password) {
        CustomerAccountSerializer s = new CustomerAccountSerializer();
        accountList = s.getCustomerAccounts("CustomerAccountData.ser");
        for (int i = 0; i < accountList.size(); i++) {
            String accountUN = accountList.get(i).getUsername();
            String accountPW = accountList.get(i).getPassword();
            System.out.println(accountUN + accountPW);
            if (accountUN.equals(username) && accountPW.equals(password)) {
                return accountList.get(i);
            }
        }
        return null;
    }

}
