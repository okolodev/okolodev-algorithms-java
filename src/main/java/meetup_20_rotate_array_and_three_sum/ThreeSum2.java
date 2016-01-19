package meetup_20_rotate_array_and_three_sum;

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
public class ThreeSum2 {

    public DynamicList<DynamicList<Integer>> threeSum(Integer[] numbers) {
        DynamicList<DynamicList<Integer>> triplets = new ArrayDynamicList<>();
        numbers = sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            if (i > 0 && numbers[i].equals(numbers[i - 1])) {
                continue;
            }

            int diff = 0 - numbers[i];
            int low = i + 1;
            int high = numbers.length - 1;

            while (low < high) {
                if (numbers[low] + numbers[high] == diff) {
                    DynamicList<Integer> triplet =
                            new ArrayDynamicList<>(numbers[i], numbers[low], numbers[high]);
                    triplets.add(triplet);

                    while (low < high && numbers[low].equals(numbers[low + 1])) {
                        low++;
                    }
                    low++;

                    while (low < high && numbers[high].equals(numbers[high - 1])) {
                        high--;
                    }
                    high--;
                } else if (numbers[low] + numbers[high] > diff) {
                    high--;
                } else {
                    low++;
                }
            }
        }

        return triplets;
    }

    private Integer[] sort(Integer[] numbers) {
        return new BottomUpMergeSort<Integer>().sort(numbers);
    }

}
