package meetup_19_n_sum;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_11_sorting.BottomUpMergeSort;

/**
 * <p>
 * 15. 3 Sum.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/3sum/">15. 3 Sum</a>
 */
public class ThreeSum {

    public DynamicList<DynamicList<Integer>> threeSum(Integer[] numbers) {
        Integer[] sorted = sort(numbers);
        int size = numbers.length;
        DynamicList<DynamicList<Integer>> triplets = new ArrayDynamicList<>();

        // [-2, -2, -2, -1, -1, -1, 3, 3]
        // [-2, -2, 4]
        int firstOccurrence = 0;
        for (int i = lastOccurrenceBinarySearch(sorted, 0);
             i < size;
             i = lastOccurrenceBinarySearch(sorted, i + 1)) {
            int first = sorted[i];
            int range = i - firstOccurrence + 1;

            for (int j = i;
                 j < size;
                 j = lastOccurrenceBinarySearch(sorted, j + 1)) {
                int second = sorted[j];

                int diff = 0 - first - second;


                int lowIndex = j + 1;

                if (range > 2) {
                    lowIndex = j;
                }

                if (binarySearch(sorted, lowIndex, diff)) {
                    triplets.add(new ArrayDynamicList<>(first, second, diff));
                }
            }

            firstOccurrence = i + 1;
        }

        return triplets;
    }

    private boolean binarySearch(Integer[] sorted, int low, int needle) {
        int high = sorted.length - 1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (needle < sorted[middle]) {
                high = middle - 1;
            } else if (needle > sorted[middle]) {
                low = middle + 1;
            } else {
                return true;
            }
        }

        return false;
    }

    private int lastOccurrenceBinarySearch(Integer[] sorted, int i) {
        if (i == sorted.length) {
            return sorted.length;
        }

        int needle = sorted[i];

        int low = i;
        int high = sorted.length - 1;
        int result = -1;

        while (low <= high) {
            int middle = low + (high - low) / 2;

            if (needle < sorted[middle]) {
                high = middle - 1;
            } else if (needle > sorted[middle]) {
                low = middle + 1;
            } else {
                result = middle;
                low = middle + 1;
            }
        }

        return result;
    }

    private Integer[] sort(Integer[] numbers) {
        return new BottomUpMergeSort<Integer>().sort(numbers);
    }

}
