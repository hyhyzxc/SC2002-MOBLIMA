package moblima.Manager;

import moblima.Entity.Account;
import moblima.Entity.User;

public interface AccountManager {
    public abstract void createNewAccount(User owner, String username, String password);

    public abstract Account validateLoginDetails(String username, String password);
}
