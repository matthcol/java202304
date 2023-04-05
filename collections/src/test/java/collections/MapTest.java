package collections;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

    @Test
    void testMap() {
        // Map<String, List<String>> with:
        // - keys: region
        // - values: list of cities of the corresponding region
        var citiesByRegion = Map.of(
                "Occitanie", List.of("Montpellier", "Toulouse"),
                "Nouvelle Aquitaine", List.of("Pau", "Bayonne", "Bordeaux"),
                "Auvergne Rhône-Alpes", List.of("Lyon", "Grenoble")
        );
        System.out.println(citiesByRegion);
        var cities = citiesByRegion.get("Occitanie");
        System.out.println(cities);

        // MAp.of: unmodifiable !
        // citiesByRegion.put("Bretagne", List.of("Rennes"));
        var citiesByRegion2 = new TreeMap<>(citiesByRegion);
        citiesByRegion2.put("Bretagne", List.of("Rennes"));
        System.out.println(citiesByRegion2);
        citiesByRegion2.put("Bretagne", List.of("Rennes", "Brest"));
        System.out.println(citiesByRegion2);

        // 3 iterations
        System.out.println("Regions:");
        for (var region: citiesByRegion2.keySet()){
            System.out.println("\t- " + region);
        }

        System.out.println("Cities:");
        for (var cityList: citiesByRegion2.values()) {
            System.out.println("\t* " + cityList);
        }

        System.out.println("Cities by region");
        for (var entry: citiesByRegion2.entrySet()) {
            System.out.print("\t# ");
            System.out.print(entry.getKey());
            System.out.print(" => ");
            System.out.println(entry.getValue());
        }
    }
}
