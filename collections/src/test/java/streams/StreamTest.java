package streams;

import org.junit.jupiter.api.Test;

import java.util.List;

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
            "Paris"
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
}
