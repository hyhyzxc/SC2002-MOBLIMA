package moblima.Entity;

import java.util.HashMap;
import java.util.Set;

import moblima.Serializer.StatusSerializer;

public class Status {
    HashMap<String, Double> status;

    public Status() {
        status = StatusSerializer.getStatusDict("StatusDatabase.ser");
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
        if (!status.containsKey(statusType)) {
            System.out.println("status type does not exist, please consult staff");
            return 0;
        }
        return status.get(statusType);
    };

    /**
     * getAllExistingKeys() returns the set of all keys stored in the HashMap.
     * This is useful in scenarios where a list of options need to be presented on
     * an UI.
     * 
     * @return a set of keys of status
     */
    public Set<String> getAllExistingKeys() {
        return status.keySet();
    }

    /**
     * Mutator for setting price proportion and adding price proportion
     * statusType is converted into all upper case, and any spacings is replaced
     * with '_'
     * 
     * @param statusType
     * @param newPrice
     */
    public void setAddPriceProportion(String statusType, double newPrice) {
        status.put(statusType.toUpperCase().replace(' ', '_'), newPrice);
        StatusSerializer.saveStatusDict(this.status, "StatusDatabase.ser");
    };

    /**
     * Deletes a specified customer type/ status from Status, if not found, since
     * remove() returns Null if key not found, the function throws a
     * NullPointerException.
     * It saves the new predefined statusType dictionary where the specified type is
     * removed.
     * 
     * @param statusType
     */
    public void delKey(String statusType) throws NullPointerException {
        try {
            status.remove(statusType.toUpperCase().replace(" ", "_"));
            StatusSerializer.saveStatusDict(this.status, "StatusDatabase.ser");
        } catch (NullPointerException e) {
            throw e;
        } catch (Exception e) {
            throw new NullPointerException();
        }

    }

}