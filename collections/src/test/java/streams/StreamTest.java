package streams;

import org.junit.jupiter.api.Test;
import region.CityTools;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTest {

    // common data for each test
    List<String> cities = List.of(
            "Toulouse",
            "Montpellier",
            "Perpignan",
            "Nice",
            "Pau",
            "Bayonne",
            "Bordeaux",
            "Paris",
            "Y",
            "Ay",
            "Orange"
    );

    @Test
    void testStream_UpperCaseList() {
        System.out.println(cities);
        var res = cities.stream()
                .map(city -> city.toUpperCase())
                .toList();
        System.out.println(res);
    }

    @Test
    void testStream_lowerCaseStartingWithB() {
        var res = cities.stream()
                .filter(city -> city.startsWith("B"))
                .map(city -> city.toLowerCase())
                .toList();
        System.out.println(res);
    }

    @Test
    void testStream_lowerCaseStartingWithB_v2() {
        var res = cities.stream()
                .filter((String city) -> city.startsWith("B"))
                .map((String city) -> city.toLowerCase())
                .toList();
        System.out.println(res);
    }

    @Test
    void testStream_Code(){
        var res = cities.stream()
               // .map(city -> CityTools.code(city))
                .map(CityTools::code)
                .toList();
        System.out.println(res);
    }

    @Test
    void testStream_Debug(){
        // limit: limit stream to a number of elements
        // skip
        // peek: does not modify stream
        System.out.println(cities);
        var res = cities.stream()
//                .skip(3)
//                .limit(5)
                .peek(city -> System.out.println("init value: " + city))
                .map(CityTools::code)
                .peek(code -> System.out.println("before filter: " + code))
                .filter(code -> code.startsWith("PA"))
                .peek(code -> System.out.println("after filter: " + code))
                .toList();
        System.out.println(res);
    }

    @Test
    void testStream_ListCitiesContainingLetterO(){
        var res = cities.stream()
                //.filter(city -> city.toLowerCase().contains("o"))
                .filter(city -> city.matches("(?i).*o.*"))
                .toList();
        System.out.println(res);
    }

    @Test
    void testStream_Codes(){
        System.out.println(cities);
        var res = cities.stream()
                .map(CityTools::code)
                .filter(code -> code.startsWith("PA"))
                .collect(Collectors.joining("-"));
        System.out.println(res);
    }

    @Test
    void testStream_FilterToCollection(){
        var res = cities.stream()
                .filter(city -> city.length() >= 4)
//                .collect(Collectors.toCollection(() -> new TreeSet<>()));
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(res);
    }

    // forEach, stats, primitive
    // nombre de villes commençant par P
    // nombre total de lettres pour écrire toutes les villes

    @Test
    void testStream_forEach(){
        cities.stream()
                .filter(city -> city.startsWith("P"))
                .forEach(city -> System.out.println(city));
    }

    @Test
    void testStream_filterAndCount(){
        var nbCities = cities.size(); // int !!
        var nbCitiesBeginningByP = cities.stream()
                .filter(city -> city.startsWith("P"))
                .count();  // long !!
        System.out.println(nbCitiesBeginningByP + " / " + nbCities);
    }

    @Test
    void test_BigCollection() throws InterruptedException {
//        var data = new ArrayList<Integer>(1_000_000_000);
//        var data = new ArrayList<Byte>(4_000_000_000L); // int is limited to 2^31-1 = 2G
        Thread.sleep(10_000);
    }

    @Test
    void test_BigStream(){
        var res = IntStream.generate(() -> 1)
                .limit(10_000_000_000L)
//                .forEach(v -> System.out.println(v));
                .count();
        System.out.println(res);
    }

    @Test
    void testStream_statsNumberOfLetters(){
        // NB: we can extract value from Optional objects
        // if we are sure there are not empty
        var totalNumberLetter = cities.stream()
                .mapToInt(String::length)
                .sum();
        System.out.println(totalNumberLetter);
        // min, max, avg
        var minNumberLetter = cities.stream()
                .mapToInt(city -> city.length())
                .min()
                .getAsInt();
        System.out.println(minNumberLetter);
        var maxNumberLetter = cities.stream()
                .mapToInt(city -> city.length())
//                .filter(n -> false)
                .max()
                .getAsInt();
        System.out.println(maxNumberLetter);
        var avgNumberLetter = cities.stream()
                .mapToInt(city -> city.length())
                .average()
                .getAsDouble();
        System.out.println(avgNumberLetter);

        var allStats = cities.stream()
                .mapToInt(city -> city.length())
                .summaryStatistics();
        System.out.println(allStats); // all stats
        System.out.println(allStats.getCount()); // one stat among all stats
        System.out.println(allStats.getAverage());

        // median
        var nbLetterSorted = cities.stream()
                .mapToInt(city -> city.length())
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(nbLetterSorted));
        int n = nbLetterSorted.length;
        double median;
        if ((n % 2) == 0) {
            median = (nbLetterSorted[n / 2] + nbLetterSorted[n / 2 - 1]) / 2.0;
        } else {
            median = nbLetterSorted[n / 2];
        }
        System.out.println("Median nb of letters: " + median);
    }
}
