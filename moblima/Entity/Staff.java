package moblima.Entity;

import java.io.Serializable;

/**
 * Represents a Staff.
 * Subclass of User Superclass.
 * Implements Serializable.
 */
public class Staff extends User implements Serializable {
    /**
     * The serialization version UID of User Class.
     */
    private static final long serialVersionUID = 8345936623728562248L;

    /**
     * Creates new Staff with given ID and name.
     * 
     * @param id   This Staff's ID.
     * @param name This Staff's name.
     */
    public Staff(int id, String name) {
        super(id, name);
    }

    /**
     * Returns the status as STAFF
     * 
     * @return enum Status
     */
    public Status getStatus() {
        return Status.STAFF;
    }
}
