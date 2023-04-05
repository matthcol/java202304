package region;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RegionTools {

    public static void addCity(
            String city,
            String region,
            Map<String, Set<String>> citiesByRegion
    ) {
        var cities = citiesByRegion.get(region);
        if (cities == null) {
        	cities = new TreeSet<>();
        	citiesByRegion.put(region, cities);
        }
        cities.add(city);
    }
}
