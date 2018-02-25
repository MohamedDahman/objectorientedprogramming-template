package oop.pset1.model;

import java.util.List;


public class Summary {

    private List<String> topMovieRate;
    private List<String> mostHiredActors;
    private List<String> mostMovieGenres;
    private String maleFemaleRatio;


    public List<String> getMostMovieGenres() {
        return mostMovieGenres;
    }

    public void setMostMovieGenres(List<String> mostMovieGenres) {
        this.mostMovieGenres = mostMovieGenres;
    }

    public String getMaleFemaleRatio() {
        return maleFemaleRatio;
    }

    public void setMaleFemaleRatio(String maleFemaleRatio) {
        this.maleFemaleRatio = maleFemaleRatio;
    }

    public List<String> getMostHiredActors() {
        return mostHiredActors;
    }

    public void setMostHiredActors(List<String> mostHiredActors) {
        this.mostHiredActors = mostHiredActors;
    }

    public List<String> getTopMovieRate() {
        return topMovieRate;
    }

    public void setTopMovieRate(List<String> topMovieRate) {
        this.topMovieRate = topMovieRate;
    }

}
