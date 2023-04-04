package collections;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SetTest {

    @Test
    void testHashSet() {
        Set<String> cities = new HashSet<>();
        cities.add("Toulouse");
        Collections.addAll(cities, "Pau", "Montpellier", "Bordeaux");
        System.out.println(cities);
        cities.add("Pau"); // doubles are not added
        System.out.println(cities);
        for (var city: cities) {
            System.out.println("\t- " + city);
        }
    }

    @Test
    void testTreeSet() {
        SortedSet<String> cities = new TreeSet<>();
        cities.add("Toulouse");
        Collections.addAll(cities, "Pau", "Montpellier", "Bordeaux");
        System.out.println(cities);
        cities.add("Pau"); // doubles are not added
        System.out.println(cities);
        cities.add("Marseille");
        System.out.println(cities);
        for (var city: cities) {
            System.out.println("\t- " + city);
        }
        // specific api for sorted sets
        System.out.println(cities.first());
        System.out.println(cities.last());
        // ranges: headSet, tailSet, subSet
        System.out.println(cities.tailSet("Marseille"));
    }

    @Test
    void sortListWithASortedSet1() {
        var cities = List.of("Toulouse", "Pau", "Montpellier", "Bayonne",
                "Paris", "Bordeaux", "Lyon", "Marseille");
        System.out.println(cities);
        SortedSet<String> citySet = new TreeSet<>();
        for (var city: cities) {
            citySet.add(city);
        }
        System.out.println(citySet);
    }

    @Test
    void sortListWithASortedSet2() {
        var cities = List.of("Toulouse", "Pau", "Montpellier", "Bayonne",
                "Paris", "Bordeaux", "Lyon", "Marseille");
        System.out.println(cities);
        SortedSet<String> citySet = new TreeSet<>();
        citySet.addAll(cities);
        System.out.println(citySet);
    }

    @Test
    void sortListWithASortedSet3() {
        var cities = List.of("Toulouse", "Pau", "Montpellier", "Bayonne",
                "Paris", "Bordeaux", "Lyon", "Marseille");
        System.out.println(cities);
        SortedSet<String> citySet = new TreeSet<>(cities);
        System.out.println(citySet);
        List<String> cityList2 = new ArrayList<>(citySet);
        System.out.println(cityList2);
    }

    @Test
    void testSetOf() {
        var cities = Set.of("Toulouse", "Pau", "Montpellier", "Bayonne",
                "Paris", "Bordeaux", "Lyon", "Marseille");
        System.out.println(cities);
        // cities.add("New York"); // java.lang.UnsupportedOperationException
    }

}
