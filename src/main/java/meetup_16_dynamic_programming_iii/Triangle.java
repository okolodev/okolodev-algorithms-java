package meetup_16_dynamic_programming_iii;

import java.util.Arrays;

/**
 * <p>
 * 120. Triangle.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/triangle/">120. Triangle</a>
 */
public class Triangle {

    public int minimumTotal(int[][] triangle) {
        int rows = triangle.length;

        if (rows == 0) {
            return 0;
        }
        if (rows == 1) {
            return triangle[0][0];
        }

        int[] pathSum = Arrays.copyOf(triangle[rows - 1], rows);

        for (int row = rows - 2; row >= 0; row--) {
            for (int column = 0; column <= row; column++) {
                pathSum[column] = Math.min(pathSum[column], pathSum[column + 1])
                        + triangle[row][column];
            }
        }

        return pathSum[0];
    }

}
