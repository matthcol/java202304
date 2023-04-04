package basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class TextTest {

    @Test
    void testCharacter(){
        char letter = 'A';
        System.out.println(letter);
    }

    @Test
    void testString(){
        String city = "Toulouse";
        System.out.println(city);
        String city2 = "東京";
        System.out.println(city2);
    }

    @Test
    void testMethods() {
        String city = "Toulouse";

        // lower/upper
        System.out.println(city.toUpperCase());
        System.out.println(city.toLowerCase());

        // extract
        System.out.println(city.substring(3));
        System.out.println(city.substring(0, 3));

        // questions
        System.out.println(city.isBlank());
        System.out.println(city.startsWith("T"));
        System.out.println(city.endsWith("z"));

        // recherche
        int index = city.indexOf("lou");
        System.out.println(index);
        index = city.indexOf("yon");
        System.out.println(index);
    }

    @ParameterizedTest
    @CsvSource({
            "Toulouse, ou",
            "Toulouse, o",
            "Toulouse, yo"
    })
    void testIndexOf(String city, String word) {
        // rechercher toutes les occurences de word dans city
        System.out.println("Find '" + word + "' in '" + city + "':");
        int index = 0;
        do {
            index = city.indexOf(word, index);
            if (index != -1) {
                System.out.println('\'' + word + "' found at index " + index);
                index += word.length();  // index = index + word.length()
            }
        } while (index != -1);
    }

    @Test
    void testEmptyBlank() {
        assertTrue("".isEmpty());
        assertTrue("".isBlank());
        assertTrue("  \t \t ".isBlank());
        assertFalse("  \t \t ".isEmpty());
    }

    @Test
    void testTrim() {
        String city = "  \tToulouse  ";
        String cityTrimmed = city.trim();
        System.out.println('[' + cityTrimmed + ']');
    }
}
