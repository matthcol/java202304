package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieLTest {

    @Test
    void testLombok(){
        var movie = new MovieL();
        var movie2 = new MovieL("Interstellar", 2019, (short) 169);
        movie.setTitle("Le Seigneur des Anneaux: les Deux Tours");
        System.out.println(movie2.getTitle());
        System.out.println(movie2);
    }
}