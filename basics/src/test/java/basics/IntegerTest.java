package basics;

import org.junit.jupiter.api.Test;

public class IntegerTest {

    @Test
    void testDeclareInit(){
        // declare with init value
        int x = 3;
        // declare without init value
        int y;
        // assignment
        y = 4;
        System.out.println(x);
        System.out.println(y);
    }

    @Test
    void testIntFamily(){
        // signed integer 16 bits
        short xs = 30000;
        // signed integer 32 bits
        int x = 2000000000;
        // signed integer 64 bits
        long xl = 9000000000000000000L;
        System.out.println("short ints from " + Short.MIN_VALUE
                + " to " + Short.MAX_VALUE
                + "; example: " + xs);
        System.out.println("ints from " + Integer.MIN_VALUE
                + " to " + Integer.MAX_VALUE
                + "; example: " + x);
        System.out.println("long ints from " + Long.MIN_VALUE
                + " to " + Long.MAX_VALUE
                + "; example: " + xl);
    }
}
