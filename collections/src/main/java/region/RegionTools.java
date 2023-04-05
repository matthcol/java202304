package region;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class RegionTools {

    /**
     * add a city associated to a region in a map
     * @param city the city to add
     * @param region the region of the city
     * @param citiesByRegion the map in which adding the city according to its region
     */
    public static void addCity(
            String city,
            String region,
            Map<String, Set<String>> citiesByRegion
    ) {
        if (citiesByRegion.containsKey(region)) {
            citiesByRegion.get(region).add(city);
        } else {
            var citySet = new TreeSet<String>();
            citySet.add(city);
            citiesByRegion.put(region, citySet);
        }
    }

    // other solution
    public static void addCity2(
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
