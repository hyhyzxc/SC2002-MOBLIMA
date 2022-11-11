package moblima.Entity;

import java.io.Serializable;
import java.util.HashMap;

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
     * Returns the price proportion corresponding to the DayType
     * 
     * @return priceProportion
     */
    public double getPriceProportion(String dayName) {
        System.out.println(dayName);
        if (dayName == null)
            return 0;
        System.out.println(dayType.get("WEEKDAY"));
        return 0;
    };

    /**
     * Mutator for setting price proportion and adding price proportion
     * 
     * @param dayName
     * @param newPrice
     */
    public void setAddPriceProportion(String dayName, double newPrice) {
        dayType.put(dayName, newPrice);
        DayTypeSerializer.saveDayTypeDict(this.dayType, "DayTypeDatabase.ser");
    };

}