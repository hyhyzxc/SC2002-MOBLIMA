package moblima.UI;

import java.util.Scanner;

import moblima.Entity.*;

public class UserUI {
	/**
     * The CustomerAccount logged into the UI.
     */
    protected static Account owner;
    /**
     * This CustomerUI's list of managers.
     */
    protected ManagerList managerList;
    /**
     * Static Scanner object for all IO.
     */
    protected static final Scanner sc = new Scanner(System.in);
    
    public UserUI(Account account, ManagerList managerList) {
        this.owner = account;
        this.managerList = managerList;
    }
    
	public void showSeatingPlan() {
		String str;
		boolean found = false;
		Cineplex cp = null;
		Cinema ci = null;
		int i = 0;
		System.out.println("Existing Cineplexes");
		for (Cineplex c : managerList.getCinemaManager().getCineplexList()) {
			System.out.println(c.getLocation());
		}
		do {
			str = sc.nextLine();
			for (Cineplex c : managerList.getCinemaManager().getCineplexList()) {
				if (str.equalsIgnoreCase(c.getLocation())) {
					cp = c;
					found = true;
				}
			}
			if (found) break;
			else System.out.println("Enter a valid Cineplex");
		} while (true);
		
		System.out.println("Cinemas of Selected Cineplex");
		for (Cinema c : cp.getTheatres()) {
			System.out.println(c.getCinemaID());
		}
		do {
			str = sc.nextLine();
			for (Cinema c : cp.getTheatres()) {
				if (str.equalsIgnoreCase(c.getCinemaID())) {
					ci = c;
					found = true;
				}
			}
			if (found) break;
			else System.out.println("Enter a valid Cinema");
		} while (true);
		
		for (Seat s : ci.getSeats()) {
			if (s.isOccupied()) {
				System.out.print("|X|");
				continue;
			}
			switch(s.getSeatType()) {
			case REGULAR:
				System.out.print("|R|");
				break;
			case ELITE:
				System.out.print("|E|");
				break;
			case ULTIMA:
				System.out.print("|U|");
				break;
			case COUPLE:
				System.out.print("|C|");
				break;
			}
			i++;
			if (i == 10) {
				System.out.println();
				i = 0;
			}
		}
	}
}
