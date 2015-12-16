package meetup_15_dynamic_programming_ii;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PerfectSquaresTest {
    private PerfectSquares perfectSquares = new PerfectSquares();

    @Test
    @Parameters(method = "data")
    public void itShouldFindLeastNumberOfPerfectSquareNumbers(int n, int numSquares) {
        assertThat(perfectSquares.numSquares(n), is(numSquares));
    }

    private Object[][] data() {
        return new Object[][]{
                {0, 0},

                {1, 1},
                {2, 2},
                {3, 3},
                {4, 1},
                {5, 2},
                {6, 3},
                {7, 4},
                {8, 2},
                {9, 1},
                {10, 2},

                {11, 3},
                {12, 3},
                {13, 2},
                {14, 3},
                {15, 4},
                {16, 1},
                {17, 2},
                {18, 2},
                {19, 3},
                {20, 2}
        };
    }

}
