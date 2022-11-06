package moblima.Manager;

import java.util.*;

import moblima.Entity.StaffAccount;
import moblima.Entity.User;
import moblima.Serializer.StaffAccountSerializer;
import moblima.UI.LoginUI;

public class StaffManager implements AccountManager {

    private ArrayList<StaffAccount> accountList;
    private int numAccounts;

    public StaffManager() {
        StaffAccountSerializer s = new StaffAccountSerializer();
        accountList = StaffAccountSerializer.getStaffAccounts("StaffAccountData.ser");
        if (accountList == null) {
            accountList = new ArrayList<StaffAccount>();
        }
        numAccounts = accountList.size();
    }

    public void createNewAccount(User owner, String username, String password) {
        StaffAccount newAccount = new StaffAccount(owner, username, password);
        accountList.add(newAccount);
        StaffAccountSerializer s = new StaffAccountSerializer();
        s.saveStaffAccounts(accountList, "StaffAccountData.ser");
        System.out.println("Staff Account Successfully Created.");

    }

    public StaffAccount validateLoginDetails(String username, String password) {
        StaffAccountSerializer s = new StaffAccountSerializer();
        accountList = s.getStaffAccounts("StaffAccountData.ser");
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
