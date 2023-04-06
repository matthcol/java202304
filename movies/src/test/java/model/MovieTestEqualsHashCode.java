package model;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
class MovieTestEqualsHashCode {

    @Test
    void testEqualsSameObject() {
        var movie = new Movie("Interstellar", 2019, (short) 169);
        assertTrue(movie.equals(movie)); // call movie.equals(movie)
    }

    @Test
    void testEqualsWithNoMovie() {
        var movie = new Movie("Interstellar", 2019, (short) 169);
        assertFalse(movie.equals("Interstellar"));
    }

    @Test
    void testEqualsWithNull() {
        var movie = new Movie("Interstellar", 2019, (short) 169);
        assertFalse(movie.equals(null));
    }

    @Test
    void testEqualsWithSameContent(){
        var movie = new Movie("Interstellar", 2019, (short) 169);
        var movie2 = new Movie("Interstellar", 2019, (short) 0);
        assertTrue(movie.equals(movie2));
        assertTrue(movie2.equals(movie));
    }

    @Test
    void testEqualsWithTitleDifferent(){
        var movie = new Movie("Interstellar", 2019, (short) 169);
        var movie2 = new Movie("Knives Out", 2019, (short) 0);
        assertFalse(movie.equals(movie2));
        assertFalse(movie2.equals(movie));
    }

    @Test
    void testEqualsWithYearDifferent(){
        var movie = new Movie("The Man Who Knew Too Much", 1934);
        var movie2 = new Movie("The Man Who Knew Too Much", 1956);
        assertFalse(movie.equals(movie2));
        assertFalse(movie2.equals(movie));
    }

    @Test
    void testEqualsHascodeCoherent(){
        var movie = new Movie("The Man Who Knew Too Much", 1934);
        System.out.println("Hashcode 1st movie: " + movie.hashCode());
        Set<Movie> movies = new HashSet<>();
        movies.add(movie);
        assertTrue(movies.contains(movie), "movie is in movies as itself");
        var movie2 = new Movie("The Man Who Knew Too Much", 1934);
        System.out.println("Hashcode 2nd movie: " + movie2.hashCode());
        assertTrue(movies.contains(movie2), "movie is in movies as a copy");
    }


}