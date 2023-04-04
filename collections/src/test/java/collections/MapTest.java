package collections;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

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
    }
}
