package meetup_32_tic_tac_toe_and_find_sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function <code>findSum(array1, array2, sum)</code> that returns
 * <code>true</code> if two numbers from two sorted arrays add up to a given
 * <code>sum</code>.
 *
 * @see <a href="https://medium.com/@evnowandforever/f-you-i-quit-hiring-is-broken-bb8f3a48d324#.n0i6nkbk1">F*** You, I Quit — Hiring Is Broken</a>
 */
public class FindSum {

    public boolean findSum(int[] firstSortedArray,
                           int[] secondSortedArray,
                           int sum) {
        Set<Integer> firstSet = new HashSet<>(firstSortedArray.length);
        for (int first : firstSortedArray) {
            firstSet.add(first);
        }

        for (int second : secondSortedArray) {
            int diff = sum - second;

            if (firstSet.contains(diff)) {
                return true;
            }
        }

        return false;
    }

    public boolean findSum2(int[] firstSortedArray,
                            int[] secondSortedArray,
                            int sum) {
        for (int first : firstSortedArray) {
            int diff = sum - first;

            if (Arrays.binarySearch(secondSortedArray, diff) >= 0) {
                return true;
            }
        }

        return false;
    }


}
