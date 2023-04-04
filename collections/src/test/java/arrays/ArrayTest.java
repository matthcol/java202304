package arrays;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayTest {

    @Test
    void testStaticArray(){
        int[] temperatures = {12, 15, 20, 30, 25};
        System.out.println(temperatures); // [I@3d36e4cd
        System.out.println(temperatures.length); // pseudo attribute
        System.out.println(Arrays.toString(temperatures));

        // acces at a specific index
        System.out.println("first value: " + temperatures[0]);
        System.out.println("last value: " + temperatures[temperatures.length - 1]);

        // access with index out of range throws exception:
        // java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
        //System.out.println(temperatures[temperatures.length]);

        // foreach (Java 5)
        for (int temperature: temperatures){
            System.out.println("\t- " + temperature);
        }

        // for index i (old way)
        for (int i = 0; i < temperatures.length; i++){
            System.out.println("\t* " + temperatures[i]);
        }
    }

    @Test
    void testDynamicArray(){
        double[] temperatures;
        temperatures = new double[1000];
        Arrays.fill(temperatures, 10.0);
        System.out.println(Arrays.toString(temperatures));
    }

    @Test
    void testArray2d(){
        int[][] matrix = {
                { 1, 5, 9},
                { 2, 3, 4},
                { 8, 7, 6}
        };
        System.out.println(Arrays.toString(matrix));
        System.out.println();
        for (int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    @Test
    void testSortBinarySearch() {
        int[] array = { 1, 5, 12, 9, 7, 8, 4};
        System.out.println(Arrays.toString(array));
        // sort algorithm from Java libraries has a cost of O(n.log(n))
        // n = 1K => cost = 10K
        // n = 1M => cost = 20M
        // n = 1G => cost = 30G
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        // search algorithm has cost of O(log(n))
        // n = 1K => cost = 10
        // n = 1M => cost = 20
        // n = 1G => cost = 30
        // n = 1E => cost = 60
        int index = Arrays.binarySearch(array, 12);
        System.out.println("Found 12 at index: " + index);
    }
}
