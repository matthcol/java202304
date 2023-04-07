package model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

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
    void demoSortStringCaseInsensitive(){
        List<String> words = List.of("Banane", "aNaNas", "fraise", "CITRON");
        var wordsSorted = words.stream()
                .sorted(String::compareToIgnoreCase)
//                .sorted((w1, w2) -> w1.compareToIgnoreCase(w2))
                .toList();
        System.out.println(wordsSorted);
    }

    @Test
    void demoSortStringFrench(){
        List<String> words = List.of(
                "étuve", "étage", "été",
                "garçon", "gare", "garbure",
                "cœur", "corps", "cobra"
        );
        Collator frenchCollator = //Collator.getInstance();
                Collator.getInstance(Locale.FRENCH);
        var wordsSorted = words.stream()
                .sorted(frenchCollator)
                .toList();
        System.out.println(wordsSorted);
    }


    @Test
    void demoSortMovies_KO_notComparable(){
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

    static Stream<Comparator<MovieL>> comparatorMovieSource(){
        return Stream.of(
                Comparator.comparing(MovieL::getTitle),
                Comparator.comparing(MovieL::getYear),
                Comparator.comparing(MovieL::getYear).reversed()
        );
    }

    @ParameterizedTest
    @MethodSource("comparatorMovieSource")
    void demoSortMovies_Comparator(Comparator<MovieL> comparator) {
        List<MovieL> movies = List.of(
                new MovieL("Top Gun", 1984, (short) 109, PgType.PG)
                , new MovieL("Top Gun: Maverick", 2022, (short) 130, PgType.PG_13)
                , new MovieL("John Wick: Chapter 4", 2023, (short) 169, PgType.R)
                , new MovieL("The Man Who Knew Too Much",1934,(short) 75, PgType.R)                , new MovieL("The Man Who Knew Too Much", 1956, (short) 120, PgType.R)
                , new MovieL("The Terminator", 1984, (short) 107, PgType.R)
                , new MovieL("Tightrope", 1984, (short) 114, PgType.R)
        );
        var moviesSorted = movies.stream()
                //.sorted(Comparator.comparing(MovieL::getTitle))
                .sorted(comparator)
                .toList();
        System.out.println();
        moviesSorted.forEach(System.out::println);
    }
}
