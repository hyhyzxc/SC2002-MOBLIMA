package moblima.Entity;

import java.util.ArrayList;

public class RegularMovie extends Movie {
    public RegularMovie(String title, String sypnosis, ShowingStatus status, String director, ArrayList<String> cast,
            int movieID, double price) {
        super(title, sypnosis, status, director, cast, movieID, price);
    }
}
