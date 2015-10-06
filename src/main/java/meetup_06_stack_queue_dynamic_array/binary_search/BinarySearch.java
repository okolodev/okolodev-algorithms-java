package meetup_06_stack_queue_dynamic_array.binary_search;

public class BinarySearch {

    public int recursiveBinarySearch(char[] array, char key) {
        return recursiveBinarySearch(array, key, 0, array.length - 1);
    }

    private int recursiveBinarySearch(char[] array, char key, int lo, int hi) {
        if (lo > hi) {
            return -lo - 1;
        }

        int middle = lo + (hi - lo) / 2;

        if (array[middle] > key) {
            return recursiveBinarySearch(array, key, lo, middle - 1);
        } else if (array[middle] < key) {
            return recursiveBinarySearch(array, key, middle + 1, hi);
        }

        return middle;
    }

    public int iterativeBinarySearch(char[] array, char key) {
        int lo = 0;
        int hi = array.length - 1;

        while (lo <= hi) {
            int middle = lo + (hi - lo) / 2;

            if (array[middle] == key) {
                return middle;
            } else if (array[middle] < key) {
                lo = middle + 1;
            } else {
                hi = middle - 1;
            }
        }

        return -lo - 1;
    }

}
