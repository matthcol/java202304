package arrays;

public class ArrayTools {

    /**
     * Search a value in an array of integers
     * @param array the array to be searched
     * @param value the value to searched for
     * @return index of value found or -1 if not found
     */
    public static int search(int[] array, int value){
        for (int i=0; i<array.length; i++) {
        	if (array[i] == value) return i;
        }
        return -1;
    }

    /**
     * Sort an array of integers with ascending order.
     * Implemented with bubble sort.
     * @param array the array to be sorted
     */
    public static void sort(int[] array) {
    	 for (int i = array.length -1; i >= 1; i--) {
    		 boolean sorted = true;
    		 for (int j = 0; j < i; j++) {
    			 if (array[j+1] < array[j]) {
    				 int tmp = array[j+1];
    				 array[j+1] = array[j];
    				 array[j] = tmp;
    				 sorted = false;
    			 }
    		 }
    		 if (sorted) return;
    	 }
    }

}
