package moblima.Entity;

import java.util.HashMap;

import moblima.Serializer.DayTypeSerializer;

public class DayType {
    public static DayTypeSerializer s = new DayTypeSerializer();
    HashMap<String, Double> dayType;

    public DayType() {
        dayType = s.getDayTypeDict("DayTypeDatabase.ser");
        if (dayType == null) {
            dayType = new HashMap<String, Double>();
            setAddPriceProportion("WEEKDAY", 1);
            setAddPriceProportion("WEEKEND", 2);
            setAddPriceProportion("PUBLIC_HOLIDAY", 3);
        }
    }

    /**
     * Returns the price proportion corresponding to the DayType
     * 
     * @return priceProportion
     */
    public double getPriceProportion(String dayName) {
        return dayType.get(dayName);
    };

    /**
     * Mutator for setting price proportion and adding price proportion
     * 
     * @param dayName
     * @param newPrice
     */
    public void setAddPriceProportion(String dayName, double newPrice) {
        dayType.put(dayName, newPrice);
        s.saveDayTypeDict(this.dayType, "DayTypeDatabase.ser");
    };

}