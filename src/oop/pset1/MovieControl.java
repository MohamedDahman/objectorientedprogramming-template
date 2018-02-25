package oop.pset1;
import oop.pset1.model.Movie;
import oop.pset1.model.MovieActors;
import java.util.*;
import java.util.stream.Collectors;

import static oop.pset1.parser.MovieActorParser.getMoviesActor;

import static oop.pset1.parser.MovieParser.getMovies;


public class MovieControl {

    public static void main(String[] args) {
        List<MovieActors> moviesActor = getMoviesActor("src/oop/pset1/data/actors.csv");
        mostHiredActors(moviesActor,5);

        double men = countHireByGender(moviesActor,2);
        double women = countHireByGender(moviesActor,1);
        double total = men + women;

        double menPercent = men / total;
        double womenPercent = women / total;
        System.out.println(menPercent);
        System.out.println(womenPercent);


        System.out.println("Gender Num 2 "+countHireByGender(moviesActor,1));

        List<Movie> movieList = getMovies("src/oop/pset1/data/movies.csv");

        List<String> genersTopNumber = getGenersTopNumber(movieList, 2);
        genersTopNumber.forEach(e-> System.out.println(e));

        List<Movie> topMovieRate = getTopMovieRate(movieList);
        topMovieRate.stream().forEach(e-> System.out.println(e.getTitle()));

    }

    public static List<Movie> getTopMovieRate(List<Movie> originalList)
    {
        return originalList.stream()
                    .sorted((e1,e2)-> e2.getVote_average().compareTo(e1.getVote_average()))
                    .limit(5)
                    .collect(Collectors.toList());
    }

    public static List<String> getGenersTopNumber(List<Movie> originalList, int top){

            Map<String, Long> appearances = originalList.stream()
                        .filter(e -> e.getGenres().size() != 0)
                .map(vote -> vote.getGenres())
                .flatMap(e -> e.stream())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

                List<String> topGeners = appearances.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " " + e.getValue() )
                        .limit(top)
                .collect(Collectors.toList());
                return topGeners;
             }



    public static List<String> mostHiredActors(List<MovieActors> originalList, int top){

        Map<String, Long> appearances = originalList.stream()
                .filter(e -> e.getActorList().size() != 0)
                .map(hirelist -> hirelist.getActorList())
                .flatMap(e -> e.stream())
                .map(e -> e.getName())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<String> topGeners = appearances.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .map(e -> e.getKey() + " " + e.getValue() )
                .limit(top)
                .peek(e-> System.out.println(e))
                .collect(Collectors.toList());
        return topGeners;
    }





    public static Integer countHireByGender(List<MovieActors> originalList, Integer Gender){
        Map<String, Long> appearances = originalList.stream()
                .filter(e -> e.getActorList().size() != 0)
                .map(hirelist -> hirelist.getActorList())
                .flatMap(e -> e.stream())
                .filter(e -> e.getGender()== Gender)
                .map(e -> e.getName())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        Integer topGeners = Math.toIntExact(appearances.entrySet().stream().count());

        return topGeners;
    }


}
