package moblima.Entity;

import java.util.HashMap;

import moblima.Serializer.StatusSerializer;

public class Status {
    public static StatusSerializer s = new StatusSerializer();
    HashMap<String, Double> status;

    public Status() {
        status = s.getStatusDict("StatusDatabase.ser");
        if (status == null) {
            status = new HashMap<String, Double>();
            setAddPriceProportion("STUDENT", 2);
            setAddPriceProportion("ADULT", 4);
            setAddPriceProportion("SENIOR_CITIZEN", 1);
            setAddPriceProportion("STAFF", 0);
        }
    }

    /**
     * Returns the price proportion corresponding to the status type
     * 
     * @return priceProportion
     */
    public double getPriceProportion(String statusType) {
        return status.get(statusType);
    };

    /**
     * Mutator for setting price proportion and adding price proportion
     * 
     * @param statusType
     * @param newPrice
     */
    public void setAddPriceProportion(String statusType, double newPrice) {
        status.put(statusType, newPrice);
        s.saveStatusDict(this.status, "StatusDatabase.ser");
    };

}