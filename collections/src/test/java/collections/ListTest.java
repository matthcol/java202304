package collections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class ListTest {

    @Test
    void testArrayList() {
        // List<int> is forbidden => use Object type
        List<Integer> temperatures = new ArrayList<>();
        System.out.println(temperatures);
        temperatures.add(12);
        temperatures.add(15);
        System.out.println(temperatures);
        temperatures.add(0, 7);
        temperatures.add(1, 9);
        System.out.println(temperatures);
        Collections.addAll(temperatures, 1, 5, 24, 38, 7);
        System.out.println(temperatures);
    }

    @Test
    void testLinkedList() {
        // creer une list d'entiers en tant que LinkedList avec les valeurs
        // 7, 9, 12, 15, 1, 5, 24, 38, 7
        List<Integer> temperatures = new LinkedList<>();
        Collections.addAll(temperatures, 7, 9, 12, 15, 1, 5, 24, 38, 7);
        System.out.println(temperatures);
    }

}
