package basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ConditionalTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 12})
    void testIf(int x) {
        if (x < 10) {
            System.out.println(x + " is little");
            x = 10 - x;
        }
        if (x % 2 == 0) {
            System.out.println(x + " is even");
        } else {
            System.out.println(x + " is odd");
        }
        if (x % 2 == 1) System.out.println(x + " is odd");
        else System.out.println(x + " is even");
        if (x % 3 == 0) {
            System.out.println(x + " is as multiple of 3");
        } else if (x % 3 == 1) {
            System.out.println(x + " is as multiple of 3 + 1");
        } else { // x % 3 == 2
            System.out.println(x + " is as multiple of 3 + 2");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 8})
    void testSwitchCase(int x) {
        switch (x % 3){
            case 0:
                System.out.println(x + " is as multiple of 3");
                break;
            case 1:
                System.out.println(x + " is as multiple of 3 + 1");
                break;
            default:
                System.out.println(x + " is as multiple of 3 + 2");
        }
    }

    /**
     * since Java 7 switch ... case on strings
     */
    @ParameterizedTest
    @ValueSource(strings={"Toulouse", "Montpellier", "Pau", "Bayonne", "Paris"})
    void testSwitchCasString(String city){
        switch (city) {
            case "Toulouse":
            case "Montpellier":
                System.out.println("I'm in Occitanie");
                break;
            case "Pau":
            case "Bayonne":
                System.out.println("I'm in Nouvelle Aquitaine");
                break;
            default:
                System.out.println("I'm in another place");
        }
    }

}
