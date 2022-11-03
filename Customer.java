import java.io.Serializable;

public class Customer extends User implements Serializable {
    private int customerID;
    private Status type;
    private String name;
    private static final long serialVersionUID = 1L;

    public Customer(int id, Status type, String name) {
        super(id, name);
        this.type = type;
    }

    public Status getStatus() {
        return type;
    }

}
