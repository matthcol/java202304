package basics;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class BooleanTest {

    @Test
    void testBoolean(){
        boolean ok = true;
        boolean nok = false;
        System.out.println(ok);
        System.out.println(nok);
    }

    @Test
    void testEqualDifferentPrimitives(){
        boolean cmp = 3 == 5; // 3 is equal to 5
        System.out.println(cmp);
        System.out.println(3 != 5);  // 3 is different from 5

        assertFalse(cmp);
        assertTrue(3 != 5);

        assertTrue(true == true);

        assertTrue('A' != 'Z');

        assertTrue(0.25 == 1.0 / 4.0);

        // 1/10e en base 10 = 0.00011001100110011001100... en base 2
        System.out.println(3 * 0.1);
        assertFalse(0.3 == 3 * 0.1);
        assertEquals(0.3, 3 * 0.1 ,1E-9);
    }

    @Test
    void testEqualDifferentStringMemory() {
        String city1 = "Toulouse";
        String city2 = "Pau";
        boolean cmp = city1 == city2; // same object in memory
        assertFalse(cmp);

        // toUpperCase called twice produces 2 objects in memory
        assertFalse(city1.toUpperCase() == city1.toUpperCase());
    }


    @Test
    void testEqualDifferentStringContent() {
        String city1 = "Toulouse";
        String city2 = "Pau";
        boolean cmp = city1.equals(city2); // same object in memory
        assertFalse(cmp);
        assertTrue(city1.toUpperCase().equals(city1.toUpperCase()));
    }

    @Test
    void testEqualsDate() {
        LocalDate today = LocalDate.now();
        LocalDate oneDay = LocalDate.of(2023,4,3);
        System.out.println(today);
        System.out.println(oneDay);

        // ok just one day: 2023-04-03
        assertTrue(today.equals(oneDay));
    }

    @Test
    void testOrderComparisonPrimitive(){
        assertTrue(3 < 5);
        assertTrue(3 <= 5);
        assertTrue(3 > 2);
        assertTrue(3 >= 3);
    }

    @Test
    void testOrderComparisonString(){
        String city1 = "Toulouse";
        String city2 = "Pau";
        // assertTrue(city2 <= city1); // forbidden in Java
        System.out.println(city2.compareTo(city1));
        assertTrue(city2.compareTo(city1) < 0);
    }

    @Test
    void combine() {
        assertTrue(!(3 > 5)); // ! = not
        assertTrue((3 > 5) || (3 < 5)); // || = or
        assertFalse((3 > 5) && (3 < 5)); // && = and
    }
}
