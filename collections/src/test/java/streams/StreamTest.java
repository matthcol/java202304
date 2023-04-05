package streams;

import org.junit.jupiter.api.Test;
import region.CityTools;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

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

    // stats, primitive
}
