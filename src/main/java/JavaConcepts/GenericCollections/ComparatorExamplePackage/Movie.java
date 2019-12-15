package JavaConcepts.GenericCollections.ComparatorExamplePackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Movie implements Comparable <Movie>{
    private double rating;
    private String name;
    private int year;

    public Movie( String name, double rating, int year) {
        this.name = name;
        this.rating = rating;
        this.year = year;
    }

    public void setRating(double rating) { this.rating = rating;  }
    public void setName(String name) {  this.name = name;  }
    public void setYear(int year) {  this.year = year;  }
    public double getRating() {return rating; }
    public String getName() {return name;  }
    public int getYear() { return year; }


    public int compareTo(Movie movie) {
        return this.year - movie.year;
    }

    public static void main(String[] args) {
        ArrayList <Movie> list = new ArrayList<>();
        list.add(new Movie("Force Awakens", 8.3, 2015));
        list.add(new Movie("Stars War", 8.7, 1977));
        list.add(new Movie("Empire Strikes Back", 8.8, 1980));
        list.add(new Movie("Return of the Jedi", 8.4, 1983));

        Collections.sort(list);
        System.out.println("Movies after sorting:");
        for (Movie movies: list ) {
            System.out.println(movies.getName()+ " "+movies.getRating()+" "+movies.getYear());
        }

        RatingCompare ratingCompare = new RatingCompare();
        Collections.sort(list, ratingCompare);
        System.out.println("After rating sort:");
        for (Movie movies: list) {
            System.out.println(movies.getName()+ " "+movies.getRating()+" "+movies.getYear());
        }
    }
}

class RatingCompare implements Comparator<Movie> {
    @Override
    public int compare(Movie m1, Movie m2) {
        return (m1.getRating()> m2.getRating()) ? 1:(m1.getRating()==m2.getRating())? 0 :-1;
    }
}
