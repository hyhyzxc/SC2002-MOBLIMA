package moblima.Serializer;

import java.util.*;

import moblima.Entity.Movie;

import java.io.*;

public class MovieSerializer extends Serializer {
    public MovieSerializer() {
        super();
    }

    public static void saveMovieList(ArrayList<Movie> o, String filename) {
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

    public static ArrayList<Movie> getMovieList(String fileName) {
        FileInputStream fi = null;
        ObjectInputStream os = null;
        ArrayList<Movie> movieList = null;
        try {
            fi = new FileInputStream(fileName);
            os = new ObjectInputStream(fi);
            movieList = ((ArrayList<Movie>) os.readObject());
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
        return movieList;
    }

}
