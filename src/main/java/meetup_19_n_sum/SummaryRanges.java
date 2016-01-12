package meetup_19_n_sum;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;

/**
 * <p>
 * 228. Summary Ranges.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/summary-ranges/">228. Summary Ranges</a>
 */
public class SummaryRanges {

    public DynamicList<String> summaryRanges(int[] numbers) {
        int size = numbers.length;
        DynamicList<String> ranges = new ArrayDynamicList<>();

        if (size == 0) {
            return ranges;
        }

        int low = 0;
        for (int high = 1; high <= size; high++) {
            if (high == size || numbers[high] > numbers[high - 1] + 1) {
                if (low == high - 1) {
                    ranges.add(String.valueOf(numbers[low]));
                } else {
                    ranges.add(numbers[low] + "->" + numbers[high - 1]);
                }
                low = high;
            }
        }

        return ranges;
    }

}
