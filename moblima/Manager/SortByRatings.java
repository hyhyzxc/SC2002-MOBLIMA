package moblima.Manager;

import java.util.ArrayList;
import java.util.HashMap;

import moblima.Entity.ManagerList;
import moblima.Entity.Movie;

public class SortByRatings implements Sorter {
	MovieManager MM = (new ManagerList()).getMovieManager();

	public HashMap<String, Float> sortBy() {
		ArrayList<Movie> movies = MM.getSorted();
		HashMap<String, Float> hm = new HashMap<>();

		for (Movie movie : movies) {
			// System.out.println(movie.getAverageRatings());
			hm.put(movie.getTitle(), movie.getAverageRatings());
		}

		return hm;

		// System.out.println("Title (Rating):");
		// for (int i = 0; i < 5; i++) {
		// System.out.printf("%s (%f)\n", movies.get(i).getTitle(),
		// movies.get(i).getAverageRatings());
		// }

	}

	@Override
	public HashMap<String, Float> sortBy(HashMap<String, Float> hm) {
		// TODO Auto-generated method stub
		return null;
	}

}
