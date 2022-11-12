package moblima.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import moblima.Serializer.DayTypeSerializer;

public class DayType implements Serializable {
    static final long serialVersionUID = 99999L;
    HashMap<String, Double> dayType;

    public DayType() {
        dayType = DayTypeSerializer.getDayTypeDict("DayTypeDatabase.ser");
        System.out.println(dayType == null);
        if (dayType == null) {
            dayType = new HashMap<String, Double>();
            dayType.put("WEEKDAY", (double) 1);
            dayType.put("WEEKEND", (double) 2);
            dayType.put("PUBLIC_HOLIDAY", (double) 3);
        }
        DayTypeSerializer.saveDayTypeDict(this.dayType, "DayTypeDatabase.ser");
    }

    /**
     * getAllExistingKeys() returns the set of all keys stored in the HashMap.
     * This is useful in scenarios where a list of options need to be presented on
     * an UI.
     * 
     * @return a set of keys of dayType
     */
    public Set<String> getAllExistingKeys() {
        return dayType.keySet();
    }

    /**
     * Returns the price proportion corresponding to the DayType
     * 
     * @return priceProportion
     */
    public double getPriceProportion(String dayName) {
        if (dayType.containsKey(dayName)) {
            return dayType.get(dayName);
        }
        System.out.println("no such day type exists! Please insert a new DayType as Staff!");
        return 0;

    };

    /**
     * Mutator for setting price proportion and adding price proportion
     * dayName is made all caps, and any space is replaced with '_'
     * 
     * @param dayName
     * @param newPrice
     */
    public void setAddPriceProportion(String dayName, double newPrice) {
        dayType.put(dayName.toUpperCase().replace(" ", "_"), newPrice);
        DayTypeSerializer.saveDayTypeDict(this.dayType, "DayTypeDatabase.ser");
    };

    /**
     * Deletes a specified day type from dayType, if not found, since remove()
     * returns Null if key not found, the function throws a NullPointerException.
     * It saves the new predefined dayType dictionary where the specified type is
     * removed.
     * 
     * @param dayName
     */
    public void delKey(String dayName) throws NullPointerException {
        try {
            dayType.remove(dayName.toUpperCase().replace(' ', '_'));
            DayTypeSerializer.saveDayTypeDict(this.dayType, "DayTypeDatabase.ser");
        } catch (NullPointerException e) {
            throw e;
        }

    }

    /**
     * Returns the hashmap containing the daytypes and their corresponding price
     * proportion.
     * 
     */
    public HashMap<String, Double> getDayList() {
        return this.dayType;
    }

}