package basics;

import org.junit.jupiter.api.Test;

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
}
