package maths;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EuclideTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 7, 9})
    void testGcd_withArgOne(int b){
        int res = Euclide.gcd(1, b);
        assertEquals(1, res);
    }

    @Test
    void testGcd_15_21(){
        int res = Euclide.gcd(15,21);
        assertEquals(3, res);
    }

    @ParameterizedTest
    @CsvSource({
            "15, 21, 3",
            "21, 15, 3",
            "12, 16, 4",
            "16, 12, 4"
    })
    void testGcd(int a, int b, int gcdExpected){
        int gcdComputed = Euclide.gcd(a, b);
        assertEquals(gcdExpected, gcdComputed);
    }

}