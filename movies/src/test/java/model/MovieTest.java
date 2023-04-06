package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * not real tests, just small scenarii illustrating how to use class Movie
 */
class MovieTest {

    @Test
    void createMovie() {
        Movie movie = new Movie(); // default constructor
        Movie movie2 = new Movie();
        System.out.println(movie);
        System.out.println(movie2);
        System.out.println(movie.getTitle());
        System.out.println(movie.getYear());
        System.out.println(movie.getDuration());
        movie.setTitle("Le Seigneur des Anneaux: les Deux Tours");
        movie2.setTitle("Interstellar");
        System.out.println(movie.getTitle());
        System.out.println(movie2.getTitle());
    }

    @Test
    void createMovieWithAllArgs(){
        var movie = new Movie("Interstellar", 2014, (short) 169);
        System.out.println(movie);
        System.out.println(movie.toString());
    }

    @Test
    void createMovieWithTitle() {
        var movie = new Movie("Interstellar");
        System.out.println(movie);
    }

    @Test
    void createMovieWithTitleYear() {
        var movie = new Movie("Interstellar", 2014);
        System.out.println(movie);
    }

    // Comparison with LocalDate
    @Test
    void encapsulationWithLocalDate(){
        var today = LocalDate.now();
        System.out.println(today);
        System.out.println(today.getYear());        // 2023
        System.out.println(today.getMonth());       // APRIL
        System.out.println(today.getDayOfMonth());  // 5
        System.out.println(today.getDayOfWeek());   // WEDNESDAY
        System.out.println(today.getDayOfYear());   // 95
    }

}