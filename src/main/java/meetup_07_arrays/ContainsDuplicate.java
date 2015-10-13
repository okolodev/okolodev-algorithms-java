package meetup_07_arrays;

import java.util.Arrays;

/**
 * @see <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] numbers) {
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                return true;
            }
        }

        return false;
    }

}
