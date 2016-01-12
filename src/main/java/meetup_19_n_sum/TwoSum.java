package meetup_19_n_sum;

import meetup_17_dictionary.Dictionary;
import meetup_17_dictionary.HashDictionary;

/**
 * <p>
 * 1. Two Sum.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        Dictionary<Integer, Integer> numberToIndex = new HashDictionary<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (!numberToIndex.contains(number)) {
                numberToIndex.insert(number, i);
            }
        }

        int[] result = null;

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            int difference = target - number;

            if (numberToIndex.contains(difference)) {
                int first = numberToIndex.get(difference) + 1;
                int second = i + 1;

                if (first == second) {
                    continue;
                }

                result = new int[]{Math.min(first, second), Math.max(first, second)};
                break;
            }
        }

        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        Dictionary<Integer, Integer> differenceToIndex = new HashDictionary<>();
        Dictionary<Integer, Boolean> usedNumbers = new HashDictionary<>();
        int[] result = null;

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (!differenceToIndex.contains(number)) {
                if (!usedNumbers.contains(number)) {
                    int difference = target - number;

                    differenceToIndex.insert(difference, i);
                    usedNumbers.insert(number, true);
                }
            } else {
                int fist = differenceToIndex.get(number) + 1;
                int second = i + 1;

                result = new int[]{fist, second};
                break;
            }
        }

        return result;
    }

}
