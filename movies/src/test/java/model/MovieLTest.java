package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieLTest {

    @Test
    void testLombok(){
        var movie = new MovieL();
        var movie2 = new MovieL("Interstellar", 2019, (short) 169);
        var movie3 = new MovieL("Interstellar", 2019, (short) 0);
        movie.setTitle("Le Seigneur des Anneaux: les Deux Tours");
        System.out.println(movie2.getTitle());
        System.out.println(movie2);
        boolean ok = movie2.equals(movie3);
        System.out.println(ok);
        assertEquals(movie2, movie2, "a movie is equals to itself");
        assertEquals(movie2, movie3, "a movie is equals to a movie with same content");
        assertNotEquals(movie, movie2);
    }
}