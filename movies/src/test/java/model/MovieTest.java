package model;

import org.junit.jupiter.api.Test;

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
        System.out.println(movie.title);
        System.out.println(movie.year);
        System.out.println(movie.duration);
        movie.title = "Le Seigneur des Anneaux: les Deux Tours";
        movie2.title = "Interstellar";
        System.out.println(movie.title);
        System.out.println(movie2.title);
    }
}