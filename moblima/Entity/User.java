package moblima.Entity;

import java.io.Serializable;

public class User implements Serializable {
    private int userID;
    private String name;
    private static final long serialVersionUID = 841221869724731376L;

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }
}
