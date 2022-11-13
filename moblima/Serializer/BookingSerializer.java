package moblima.Serializer;

import java.util.ArrayList;
import java.io.*;
import moblima.Entity.Booking;

public class BookingSerializer extends Serializer {
    public BookingSerializer() {
        super();
    }

    public static void saveBookings(ArrayList<Booking> o, String filename) {
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

    public static ArrayList<Booking> getBookings(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Booking> bookings = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            bookings = ((ArrayList<Booking>) os.readObject());
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
        return bookings;
    }
}
