import java.io.Serializable;

public class Customer implements Serializable {
    private int customerID;
    private Status type;
    private String name;

    public Customer(int id, Status type, String name) {
        this.customerID = id;
        this.type = type;
        this.name = name;
    }

}
