package homework5;/*
 * SD2x Homework #5
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;


public class MovieRatingsProcessor {

    public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
        List<String> movies = new Vector<String>();

        if (movieRatings != null) {
            for (Map.Entry<String, PriorityQueue<Integer>> mov : movieRatings.entrySet()) {
                movies.add(mov.getKey());
            }
        }
        return movies;
    }

    public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
        List<String> movies = new Vector<String>();

        if (movieRatings != null) {
            for (Map.Entry<String, PriorityQueue<Integer>> mov : movieRatings.entrySet()) {
                Iterator<Integer> q = mov.getValue().iterator();
                boolean isExist = true;
                while (q.hasNext()) {
                    Integer val = q.next();
                    if (val <= rating) {
                        isExist = false;
                        break;
                    }
                }
                if (isExist) movies.add(mov.getKey());
            }
        }
        return movies;
    }

    public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {

        TreeMap<String, Integer> movies = new TreeMap<String, Integer>();

        List<String> toBeDeletedString = new ArrayList<String>();

        if (movieRatings != null) {
            for (Map.Entry<String, PriorityQueue<Integer>> mov : movieRatings.entrySet()) {

                Iterator<Integer> q = mov.getValue().iterator();
                Integer count = 0;
                List<Integer> toBeDelete = new ArrayList<Integer>();
                while (q.hasNext()) {
                    Integer value = q.next();
                    if (value < rating) {
                        count++;
                        toBeDelete.add(value);
                    }
                }

                if (count != 0) movies.put(mov.getKey(), count);

                for (Integer deleteValue : toBeDelete) {
                    mov.getValue().remove(deleteValue);
                }

                if (mov.getValue().size() == 0) {
                    toBeDeletedString.add(mov.getKey());
                }

            }
        }


        for (String value : toBeDeletedString) {
            movieRatings.remove(value);
        }

        return movies;
    }
}
