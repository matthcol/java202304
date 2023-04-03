package maths;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EuclideTest {

    @Test
    void testGcd_withArgOne(){
        int res = Euclide.gcd(1, 3);
        assertEquals(1, res);
    }

    @Test
    void testGcd_15_21(){
        int res = Euclide.gcd(15,21);
        assertEquals(3, res);
    }

}