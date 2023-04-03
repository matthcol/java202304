package basics;

import org.junit.jupiter.api.Test;

public class ConditionalTest {

    @Test
    void testIf() {
        int x = 5;
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
}
