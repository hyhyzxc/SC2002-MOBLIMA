package moblima.Entity;

import java.io.Serializable;

public class Staff extends User implements Serializable {
    private int staffID;
    private String name;
    private static final long serialVersionUID = 8345936623728562248L;

    public Staff(int id, String name) {
        super(id, name);
    }

}
