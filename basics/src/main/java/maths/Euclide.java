package maths;

public class Euclide {

    /**
     * Compute the gcd of two natural integers
     * @param a first number (must be > 0)
     * @param b second number (must be > 0)
     * @return the gcd of a and b
     */
    public static int gcd(int a, int b){
        // TODO: reject numbers <= 0
        while (a != b) {
            if (a > b) a =  a - b;
            else b = b - a;
        }
        return a;
    }
}
