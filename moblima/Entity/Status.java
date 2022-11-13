package moblima.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

import moblima.Serializer.StatusSerializer;
/**
 * Represents a Status.
 * @author Yap Shen Hwei
 * @version 1.0
 * @since 2022-11-13
 */
public class Status {
    LinkedHashMap<String, Double> status;
    /**
     * Creates a new Status.
     */
    public Status() {
        status = StatusSerializer.getStatusDict("StatusDatabase.ser");
        if (status == null) {
            status = new LinkedHashMap<String, Double>();
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
     * getAllExistingKeys() returns the array of all keys stored in the HashMap.
     * This is useful in scenarios where a list of options need to be presented on
     * an UI.
     * 
     * @return an array of keys of statuses.
     */
    public ArrayList<String> getAllExistingKeys() {
        Set<String> keys = status.keySet();
        ArrayList<String> keysArray = new ArrayList<String>(keys);
        return keysArray;
    }

    /**
     * Gets the key according to the index
     * 
     * @return day key string
     */
    public String getKey(int i) {
        return getAllExistingKeys().get(i);
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

    /**
     * Returns the status list
     */
    public LinkedHashMap<String, Double> getStatusList() {
        return this.status;
    }

    /**
     * returns the size of the status list
     */
    public int getSize() {
        return this.status.size();
    }

    /**
     * Prints the status type structure so that staff can view the different
     * type statuses of customers and
     * their corresponding price proportion.
     */
    public void printStatus() {
        int i = 1;
        for (String s : status.keySet()) {
            System.out.printf("%d. %s : %.1f\n", i++, s, status.get(s));
        }
        System.out.println("\n-------------------------\n");
    }
}