package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayToolsTest {

    @Test
    void testSearchOk(){
        int[] array = { 1, 5, 12, 7, 8, 4};
        int value = 12;
        int index = ArrayTools.search(array, value);
        assertEquals(2, index);
    }

    @Test
    void testSearchKo(){
        int[] array = { 1, 5, 12, 7, 8, 4};
        int value = 11;
        int index = ArrayTools.search(array, value);
        assertEquals(-1, index);
    }

    @Test
    void testSort(){
        int[] array = { 5, 1, 12, 7, 8, 4};
        int[] arraySortedExpected = { 1, 4, 5, 7, 8, 12};
        ArrayTools.sort(array);
        assertArrayEquals(arraySortedExpected, array);
    }

}