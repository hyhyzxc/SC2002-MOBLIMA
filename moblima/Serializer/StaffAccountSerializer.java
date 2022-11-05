package moblima.Serializer;

import java.util.*;

import moblima.Entity.StaffAccount;

import java.io.*;

public class StaffAccountSerializer extends Serializer {
    public StaffAccountSerializer() {
        super();
    }

    public static void saveStaffAccounts(ArrayList<StaffAccount> o, String filename) {
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

    public static ArrayList<StaffAccount> getStaffAccounts(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<StaffAccount> peopleList = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            peopleList = ((ArrayList<StaffAccount>) os.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
                fi.close();
            } catch (Exception e) {
                // if this fails, it's probably open, so just do nothing
            }
        }
        return peopleList;
    }
}
