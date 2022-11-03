import java.util.*;
import java.io.*;

public class CustomerManager {
    private ArrayList<CustomerAccount> accountList;
    private int numAccounts;

    public CustomerManager() {
        numAccounts = 0;
        accountList = Serializer.getCustomerAccounts("CustomerAccountData.ser");
        if (accountList == null) {
            accountList = new ArrayList<CustomerAccount>();
        }
    }

    public void createNewAccount(Customer owner, String username, String password) {
        CustomerAccount newAccount = new CustomerAccount(owner, username, password);
        accountList.add(newAccount);
        Serializer.saveCustomerAccounts(accountList, "CustomerAccountData.ser");

        System.out.println("Customer Account Successfully Created.");
        LoginUI.main(null);
    }

    public CustomerAccount validateLoginDetails(String username, String password) {
        accountList = Serializer.getCustomerAccounts("CustomerAccountData.ser");
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
