package meetup_15_dynamic_programming_ii;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ClimbingStairsTest {
    private ClimbingStairs climbingStairs = new ClimbingStairs();

    @Test
    @Parameters(method = "data")
    public void itShouldCountNumberOfDistinctWaysToClimbStairs(int stairs, int ways) {
        assertThat(climbingStairs.climbStairs(stairs), is(ways));
    }

    private Object[][] data() {
        return new Object[][]{
                {0, 1},
                {1, 1},
                {2, 2},
                {3, 3},
                {4, 5},
                {5, 8},
                {6, 13}
        };
    }

}
