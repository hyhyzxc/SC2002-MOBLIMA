package moblima.Entity;

import java.io.Serializable;
import java.util.HashMap;

import moblima.Serializer.StaffConfigsSerializer;

/**
 * Represents a StaffConfigs.
 * Concrete base class that implements the Serializable interface. 
 */
public class StaffConfigs implements Serializable {

	/**
	 * List of configs.
	 */
	 
	private HashMap<String, Boolean> configs;

	/**
	 * Creates a new Staff Config.
	 */
	public StaffConfigs() {
		configs = StaffConfigsSerializer.getStaffConfigs("StaffConfigsDatabase.ser");
		if (configs == null) {
			configs = new HashMap<String, Boolean>();
			configs.put("VIEW_BY_RATINGS", true);
			configs.put("VIEW_BY_NUM_SALES", true);
			StaffConfigsSerializer.saveStaffConfigs(configs, "StaffConfigsDatabase.ser");
		}
	}
	/**
	 * Gets the current configuration.
	 * @return this StaffConfigs' configs. 
	 */
	public HashMap<String, Boolean> getCurrentConfigs() {
		return configs;
	}
	/**
	 * Displays the current configuration. 
	 */
	public void printCurrentConfigs() {
		for (String c : configs.keySet()) {
			System.out.printf("%s : %s \n", c, configs.get(c));
		}
	}

	/**
	 * Modifies the current configuration with the given toChange and newBool values. 
	 * @param toChange Item to be changed.
	 * @param newBool Boolean variable to set Item to.
	 */
	public void changeConfigs(String toChange, boolean newBool) {
		try {
			if (configs.containsKey(toChange)) {
				configs.put(toChange, newBool);
				System.out.println("Succesfully changed!");
				StaffConfigsSerializer.saveStaffConfigs(configs, "StaffConfigsDatabase.ser");
			} else {
				System.out.println("Sorry please only choose from the available configs");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
