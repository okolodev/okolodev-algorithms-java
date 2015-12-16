package meetup_15_dynamic_programming_ii;

/**
 * <p>
 * Climbing Stairs.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/climbing-stairs/">70 Climbing Stairs</a>
 */
public class ClimbingStairs {

    public int climbStairs(int stairs) {
        return climbStairs(stairs, new int[stairs + 1]);
    }

    private int climbStairs(int stairs, int[] cache) {
        if (cache[stairs] != 0) {
            return cache[stairs];
        }

        if (stairs == 0) {
            cache[0] = 1;

            return cache[0];
        }

        if (stairs == 1) {
            cache[1] = 1;

            return cache[1];
        }

        cache[stairs] = climbStairs(stairs - 2, cache)
                + climbStairs(stairs - 1, cache);
        return cache[stairs];
    }

}
