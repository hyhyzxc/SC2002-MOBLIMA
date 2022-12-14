package moblima.Entity;

import java.io.Serializable;

/**
 * Represents a Customer
 * Concrete base class that extends the User.
 * Concrete base class that implements the Serializable interface.
 * @author Goh Hong Yi
 * @version 1.0
 * @since 2022-11-13
 */
public class Customer extends User implements Serializable {
    /**
     * The type of this Customer.
     */
    private String type;
    /**
     * The email of this Customer.
     */
    private String email;
    /**
     * The mobile number of this Customer.
     */
    private String phoneNumber;
    /**
     * The serialVersionUID of this Customer.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new Customer with given id, type, name, email, phoneNumber
     * 
     * @param id          This Customer's id.
     * @param type        This Customer's type.
     * @param name        This Customer's name.
     * @param email       This Customer's email.
     * @param phoneNumber This Customer's phoneNumber.
     */
    public Customer(int id, String type, String name, String email, String phoneNumber) {
        super(id, name);
        this.type = type;
    }

    /**
     * Gets the type of this Customer.
     * 
     * @return this Customer's type.
     */
    public String getStatus() {
        return this.type;
    }

    /**
     * Gets the email of this Customer.
     * 
     * @return this customer's email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Gets the mobile number of this Customer.
     * 
     * @return this Customer's phoneNumber.
     */
    public String getNumber() {
        return this.phoneNumber;
    }

}
