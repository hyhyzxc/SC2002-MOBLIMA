package moblima.UI;

import moblima.Database.*;
import moblima.Entity.*;
import moblima.Exceptions.*;
import moblima.Manager.*;
import java.util.*;

public class BookingUI {
    private static CustomerAccount owner;
    private ManagerList managerList = new ManagerList();
    static final Scanner sc = new Scanner(System.in);
    static final CustomerUI customerUI = new CustomerUI(owner);

    public CustomerUI(CustomerAccount account) {
        this.owner = account;
    }
}
