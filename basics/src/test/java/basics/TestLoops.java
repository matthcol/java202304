package basics;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class TestLoops {

    @Test
    void testWhile() {
        int cpt = 10;
        while (cpt >= 0) {
            System.out.println(cpt);
            cpt--;
        }
    }

//    @Test
//    void testWhileInfinite() {
//        int cpt = Integer.MAX_VALUE;
//        while (cpt >= 0) {
//            System.out.println(cpt);
//            cpt = Math.abs(cpt - 1);
//        }
//    }

    @ParameterizedTest
    @ValueSource(ints={0,1,2})
    void testDoWhile(int cpt){
        System.out.println("do while with init cpt = " + cpt);
        do {
           System.out.println(cpt);
           cpt--;
        } while (cpt > 0);
        System.out.println();
    }
}
