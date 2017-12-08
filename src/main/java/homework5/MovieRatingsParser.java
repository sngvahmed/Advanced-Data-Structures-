package homework5;/*
 * SD2x Homework #5
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

    public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {

        TreeMap<String, PriorityQueue<Integer>> res = new TreeMap<String, PriorityQueue<Integer>>();
        if (allUsersRatings != null) {
            for (UserMovieRating userMovieRating : allUsersRatings) {
                if (userMovieRating == null || userMovieRating.movie == null || userMovieRating.movie.equals("")
                        || userMovieRating.userRating < 0) continue;
                userMovieRating.movie = userMovieRating.movie.toLowerCase();
                if (res.get(userMovieRating.movie) == null)
                    res.put(userMovieRating.movie, new PriorityQueue<Integer>());
                res.get(userMovieRating.movie).add(userMovieRating.userRating);
            }
        }
        return res;
    }

}
