package moblima.Entity;

import java.io.Serializable;
import java.util.HashMap;

import moblima.Serializer.StaffConfigsSerializer;

public class StaffConfigs implements Serializable {
	private HashMap<String, Boolean> configs;

	public StaffConfigs() {
		configs = StaffConfigsSerializer.getStaffConfigs("StaffConfigsDatabase.ser");
		if (configs == null) {
			configs = new HashMap<String, Boolean>();
			configs.put("VIEW_BY_RATINGS", true);
			configs.put("VIEW_BY_NUM_SALES", true);
			StaffConfigsSerializer.saveStaffConfigs(configs, "StaffConfigsDatabase.ser");
		}
	}

	public void changeConfigs(String toChange, boolean newBool) {
		try {
			if (configs.containsKey(toChange)) {
				configs.put(toChange, newBool);
				System.out.println("Succesfully changed!");
			} else {
				System.out.println("Sorry please only choose from the available configs");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
