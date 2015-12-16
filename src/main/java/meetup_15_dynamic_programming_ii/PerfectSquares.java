package meetup_15_dynamic_programming_ii;

/**
 * <p>
 * Perfect Squares.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/perfect-squares/">279 Perfect Squares</a>
 */
public class PerfectSquares {

    public int numSquares(int n) {
        if (n < 1) {
            return 0;
        }

        int[] cache = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int root = (int) Math.sqrt(i);

            if (root * root == i) {
                cache[i] = 1;
                continue;
            }

            cache[i] = i;

            for (int j = 1; j <= root; j++) {
                int diff = i - j * j;
                if (cache[diff] + 1 < cache[i]) {
                    cache[i] = cache[diff] + 1;
                }
            }
        }

        return cache[n];
    }

}
