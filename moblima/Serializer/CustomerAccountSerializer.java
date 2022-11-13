package moblima.Serializer;

import java.util.*;
import java.io.*;

import moblima.Entity.CustomerAccount;
import moblima.Exceptions.*;
import moblima.Manager.*;

public class CustomerAccountSerializer extends Serializer {
    public CustomerAccountSerializer() {
        super();
    }

    public static void saveCustomerAccounts(ArrayList<CustomerAccount> o, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    public static ArrayList<CustomerAccount> getCustomerAccounts(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<CustomerAccount> accountList = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            accountList = ((ArrayList<CustomerAccount>) os.readObject());
        } catch (FileNotFoundException e) {
            // e.printStackTrace();
        } catch (EOFException e) {
            // e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
        } catch (IOException e) {
            // e.printStackTrace();
        } catch (Exception e) {
            // e.printStackTrace();
        } finally {
            try {
                os.close();
                fi.close();
            } catch (Exception e) {
                // if this fails, it's probably open, so just do nothing
            }
        }
        return accountList;
    }
}
