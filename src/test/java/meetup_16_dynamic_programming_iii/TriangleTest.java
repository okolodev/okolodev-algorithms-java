package meetup_16_dynamic_programming_iii;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TriangleTest {
    private Triangle triangleSumFinder = new Triangle();

    @Test
    @Parameters(method = "triangles")
    public void itShouldFindMinimumPathSum(int[][] triangle, int minimumSum) {
        assertThat(triangleSumFinder.minimumTotal(triangle), is(minimumSum));
    }

    private Object[][] triangles() {
        return new Object[][]{
                {new int[][]{}, 0},
                {new int[][]{{3}}, 3},
                {new int[][]{
                        {3},
                        {4, 5}},
                        7},
                {new int[][]{
                        {3},
                        {4, 5},
                        {8, 7, 2}},
                        10},
                {new int[][]{
                        {2},
                        {3, 4},
                        {6, 5, 7},
                        {4, 1, 8, 3}},
                        11},
                {new int[][]{
                        {-2},
                        {-3, -4},
                        {-6, -5, -7},
                        {-4, -1, -8, -3}},
                        -21}
        };
    }

}
