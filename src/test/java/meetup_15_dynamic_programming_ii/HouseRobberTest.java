package meetup_15_dynamic_programming_ii;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class HouseRobberTest {
    private HouseRobber robber = new HouseRobber();

    @Test
    @Parameters(method = "data")
    public void itShouldCalculateMaximumAmountToSteal(int houses[], int maxAmount) {
        assertThat(robber.rob(houses), is(maxAmount));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldCalculateMaximumAmountToStealDynamic(int houses[],
                                                             int maxAmount) {
        assertThat(robber.robDynamic(houses), is(maxAmount));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{}, 0},
                {new int[]{1}, 1},
                {new int[]{2, 4, 1, 12, 20, 30}, 46},
                {new int[]{9, 10, 1, 2, 8}, 18},
                {new int[]{10, 10, 1, 2, 8}, 19},
                {new int[]{100, 90, 1, 12, 30, 20}, 132},
                {new int[]{100, 90, 1, 12, 30, 20, 100, 90, 1, 12, 30, 20}, 263},
                {new int[]{100, 90, 1, 12, 30, 20, 0, 100, 90, 1, 12, 30, 20}, 264},
                {new int[]{20, 30, 12, 1, 90, 100, 0, 20, 30, 12, 1, 90, 100}, 264}
        };
    }

}
