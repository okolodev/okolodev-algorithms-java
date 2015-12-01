package meetup_14_multiway_merge_and_dynamic_programming;

/**
 * Unique Paths II.
 *
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/">63 Unique Paths II</a>.
 */
public class UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;

        if (rows == 0) {
            return 0;
        }

        int columns = obstacleGrid[0].length;

        if (columns == 0) {
            return 0;
        }

        int[][] grid = new int[rows][columns];

        fillTopRow(grid, obstacleGrid, columns);
        fillLeftColumn(grid, obstacleGrid, rows);

        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                if (obstacleGrid[row][column] == 0) {
                    grid[row][column] = grid[row][column - 1] + grid[row - 1][column];
                } else {
                    continue;
                }
            }
        }

        return grid[rows - 1][columns - 1];
    }

    private void fillTopRow(int[][] grid, int[][] obstacleGrid, int columns) {
        for (int column = 0; column < columns; column++) {
            if (obstacleGrid[0][column] == 1) {
                break;
            }

            grid[0][column] = 1;
        }
    }

    private void fillLeftColumn(int[][] grid, int[][] obstacleGrid, int rows) {
        for (int row = 0; row < rows; row++) {
            if (obstacleGrid[row][0] == 1) {
                break;
            }

            grid[row][0] = 1;
        }
    }

}
