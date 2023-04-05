package region;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RegionToolsTest {

    // variable = attribute for each test
    Map<String, Set<String>> citiesByRegion;

    @BeforeEach
    void initData(){
        citiesByRegion = new TreeMap<>();
        var citiesOccitanie = new TreeSet<String>();
        Collections.addAll(citiesOccitanie, "Toulouse", "Montpellier");
        citiesByRegion.put("Occitanie", citiesOccitanie);
        var citiesNouvelleAquitaine = new TreeSet<String>();
        Collections.addAll(citiesNouvelleAquitaine, "Bayonne", "Pau");
        citiesByRegion.put("Nouvelle Aquitaine", citiesNouvelleAquitaine);
    }

    @Test
    void testAddCity_RegionPresent(){
        String city = "Perpignan";
        String region = "Occitanie";
        RegionTools.addCity(city, region, citiesByRegion);
        System.out.println(citiesByRegion);
        // verify
        var citiesOccitanie = citiesByRegion.get(region);
        assertTrue(citiesOccitanie.contains(city));
        assertEquals(3, citiesOccitanie);
    }

    @Test
    void testAddCity_RegionNotPresent(){
        String city = "Rennes";
        String region = "Bretagne";
        RegionTools.addCity(city, region, citiesByRegion);
        System.out.println(citiesByRegion);
        // verify
        var citiesBretagne = citiesByRegion.get(region);
        assertNotNull(citiesBretagne);
        assertTrue(citiesBretagne.contains(city));
        assertEquals(1, citiesBretagne);
    }
}