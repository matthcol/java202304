package collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ListTest {

    @Test
    void testArrayList() {
        // List<int> is forbidden => use Object type
        List<Integer> temperatures = new ArrayList<>();
        System.out.println(temperatures);
        temperatures.add(12);
        temperatures.add(15);
        System.out.println(temperatures);
        temperatures.add(0, 7);
        temperatures.add(1, 9);
        System.out.println(temperatures);
        Collections.addAll(temperatures, 1, 5, 24, 38, 7);
        System.out.println(temperatures);
        int s = ListTools.sum(temperatures);
        System.out.println("Sum: " + s);
    }

    @Test
    void testLinkedList() {
        // creer une list d'entiers en tant que LinkedList avec les valeurs
        // 7, 9, 12, 15, 1, 5, 24, 38, 7
        List<Integer> temperatures = new LinkedList<>();
        Collections.addAll(temperatures, 7, 9, 12, 15, 1, 5, 24, 38, 7);
        System.out.println(temperatures);
        int s = ListTools.sum(temperatures);
        System.out.println("Sum: " + s);
        Collections.sort(temperatures);
        System.out.println(temperatures);
    }
    @Test
    void testListCities() {
        List<String> cities = new ArrayList<>();
        Collections.addAll(cities, "Toulouse", "Pau", "Montpellier",
                "Bayonne", "Paris", "Bordeaux", "Lyon", "Marseille");
        System.out.println(cities);
        // Exo: en utilisant au maximum par l'API
        // afficher les villes une par ligne
        for (String city:  cities) {
            System.out.println("\t- " + city);
        }
        // afficher la ville numéro 3
        String city = cities.get(3);
        System.out.println("City #3: " + city);
        // chercher la position de Bayonne
        int index = cities.indexOf("Bayonne");
        System.out.println("Bayonne found at index: " + index);
        // remplacer la ville 3 par Biarritz
        cities.set(3, "Biarritz");
        System.out.println(cities);
        // tri
        Collections.sort(cities);
        System.out.println(cities);
    }

    @Test
    void testSmallListOfValues() {
        // Warning: use only for small lists in tests only
        // this list is unmodifiable !
        var cities = List.of("Toulouse", "Pau", "Montpellier", "Bayonne",
                "Paris", "Bordeaux", "Lyon", "Marseille");
        System.out.println(cities);
        // cities.add("Rennes"); // java.lang.UnsupportedOperationException
        // Collections.sort(cities); // java.lang.UnsupportedOperationException
        for (var city: cities) {
            System.out.println("\t- " + city);
        }
        System.out.println("City count: " + cities.size());
        System.out.println("Bayonne in city list: " + cities.contains("Bayonne"));
        System.out.println("Pau and Paris in city list: "
                + cities.containsAll(List.of("Pau", "Paris")));
    }

    @Test
    void testListOfList(){
        // cities has type List<List<String>>
        var cityListOfList = List.of(
                List.of("Montpellier", "Toulouse"),
                List.of("Pau", "Bayonne", "Bordeaux"),
                List.of("Lyon", "Grenoble")
        );
        for (var cityList: cityListOfList) {
            System.out.println("City list: " + cityList);
            for (var city: cityList) {
                System.out.println("\t- " + city);
            }
        }
        // Exo: flatten list of list of cities in one list of cities
        List<String> allCities = new ArrayList<>();
        for (var cityList: cityListOfList) {
        	allCities.addAll(cityList);
        }
        System.out.println(allCities);
    }

}
