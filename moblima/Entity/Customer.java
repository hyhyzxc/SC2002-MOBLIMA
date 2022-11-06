package moblima.Entity;

import java.io.Serializable;

public class Customer extends User implements Serializable {
    private int customerID;
    private Status type;
    private String name;
    private String email;
    private String phoneNumber; 
    private static final long serialVersionUID = 1L;

    public Customer(int id, Status type, String name, String email, String phoneNumber) {
        super(id, name);
        this.type = type;
    }

    public Status getStatus() {
        return this.type;
    }

    public String getEmail(){
        return this.email;
    }

    public String getNumber(){
        return this.phoneNumber;
    }

}
