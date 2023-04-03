package basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FloatTest {

    @Test
    void testFloatFamily() {
        // float double precision (64 bits)
        double x = 3.14;
        // float simple precision (32 bits)
        float xf = 3.14f;
        System.out.println(x);
        System.out.println(xf);
    }

    @Test
    void computeDouble() {
        double x = 5.0;
        double y = 4.0;
        // NB: / double division  => result double with a certain precision
        double z = (x + y) * (x - 3.0) / 7.0;
        System.out.println(z);
    }

    @Test
    void computeIntDouble() {
        int x = 5;
        int y = 4;
        // NB: / double division  => result double with a certain precision
        double z = (x + y) * (x - 3) / 7;
        System.out.println(z);
        double zz = (x + y) * (x - 3) / 7.0;
        System.out.println(zz);
        int zi = (int) zz;
        System.out.println(zi);
        int zNearer = (int) Math.round(zz);
        System.out.println("Round: " + zNearer);
        int zCeil = (int) Math.ceil(zz);
        System.out.println("Ceil: " + zCeil);
        int zFloor = (int) Math.floor(zz);
        System.out.println("Floor: " + zFloor);
    }

    @Test
    void trigo() {
        double res = Math.sin(2*Math.PI);
        System.out.println(res);
        assertEquals(0.0, res);
    }

    @Test
    void infinity() {
        double inf = Double.POSITIVE_INFINITY;
        System.out.println(inf);
        System.out.println(1.0 / inf);
        System.out.println(1.0 / 0.0);
        System.out.println(- inf);
    }

    @Test
    void testNan(){
        double nan = Double.NaN;
        System.out.println(nan);
        System.out.println(nan + 1);
        System.out.println(nan * 7);
    }

    @Test
    void testBigDoubles(){
        double big = 1E308;
        double bigMax = Double.MAX_VALUE;
        System.out.println(big);
        System.out.println(bigMax);
        System.out.println(big * 2); // +Inf
    }

    @Test
    void testBigFloats(){
        float big = 1E38F;
        float bigMax = Float.MAX_VALUE;
        System.out.println(big);
        System.out.println(bigMax);
        System.out.println(big * 4); // +Inf
    }
}
