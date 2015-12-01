package meetup_14_multiway_merge_and_dynamic_programming;

/**
 * Unique Paths.
 *
 * @see <a href="https://leetcode.com/problems/unique-paths/">62 Unique Paths</a>.
 */
public class UniquePaths {

    // https://en.wikipedia.org/wiki/Binomial_coefficient#Multiplicative_formula
//    public int uniquePaths(int n, int m) {
//        if (n == 1 || m == 1) {
//            return 1;
//        }
//
//        return binomialCoefficient(m + n - 2, Math.min(m, n) - 1);
//    }
//
//    private int binomialCoefficient(int n, int k) {
//        k = Math.min(k, n - k);
//        long result = 1;
//
//        for (int i = 0; i < k; i++) {
//            result = result * (n - i) / (i + 1);
//        }
//
//        return (int) result;
//    }

    public int uniquePaths(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }

        int[][] grid = new int[n][m];

        fillTopRow(grid, m);
        fillLeftColumn(grid, n);

        for (int row = 1; row < n; row++) {
            for (int column = 1; column < m; column++) {
                grid[row][column] = grid[row][column - 1] + grid[row - 1][column];
            }
        }

        return grid[n - 1][m - 1];
    }

    private void fillTopRow(int[][] grid, int columns) {
        for (int column = 0; column < columns; column++) {
            grid[0][column] = 1;
        }
    }

    private void fillLeftColumn(int[][] grid, int rows) {
        for (int row = 0; row < rows; row++) {
            grid[row][0] = 1;
        }
    }

}
