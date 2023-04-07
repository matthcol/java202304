package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class SortDemo {

    @Test
    void compareStrings(){
        String word1 = "banane";
        String word2 = "ananas";
        // String implements Comparable<String>
        // => int compareTo(String other)
        // return <0, =0, >0 resp less, equals, greater
        // this method is the natural order for class String
        int res = word1.compareTo(word2);
        System.out.println(res);
    }

    @Test
    void demoSortString(){
        List<String> words = List.of("banane", "ananas", "fraise", "citron");
        var wordsSorted = words.stream().sorted().toList();
        System.out.println(wordsSorted);
    }

    @Test
    void demoSortMovies_KO(){
        List<MovieL> movies = List.of(
                new MovieL("Top Gun", 1984, (short) 109, PgType.PG)
                , new MovieL("Top Gun: Maverick", 2022, (short) 130, PgType.PG_13)
                , new MovieL("John Wick: Chapter 4", 2023, (short) 169, PgType.R)
        );
        // Impossible: MovieL is not Comparable
        assertThrows(ClassCastException.class, () -> {
            var moviesSorted = movies.stream().sorted().toList();
            System.out.println(moviesSorted);
        });
    }
}
