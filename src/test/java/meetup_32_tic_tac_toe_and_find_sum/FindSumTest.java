package meetup_32_tic_tac_toe_and_find_sum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class FindSumTest {
    private FindSum sumFinder = new FindSum();

    @Test
    @Parameters(method = "findSum")
    public void itShouldFindSum(int[] firstSortedArray,
                                int[] secondSortedArray,
                                int sum) {
        assertThat(sumFinder.findSum(firstSortedArray, secondSortedArray, sum),
                is(true));
    }

    @Test
    @Parameters(method = "findSum")
    public void itShouldFindSum2(int[] firstSortedArray,
                                 int[] secondSortedArray,
                                 int sum) {
        assertThat(sumFinder.findSum2(firstSortedArray, secondSortedArray, sum),
                is(true));
    }

    private Object[][] findSum() {
        return new Object[][]{
                {new int[]{0}, new int[]{0}, 0},
                {new int[]{1}, new int[]{2}, 3},
                {new int[]{1, 4}, new int[]{5, 8}, 9},
                {new int[]{4, 6, 7}, new int[]{-1, 2, 3}, 5},
                {new int[]{4, 6, 6}, new int[]{-1, 2, 8}, 14}
        };
    }

    @Test
    @Parameters(method = "notFindSum")
    public void itShouldNotFindSum(int[] firstSortedArray,
                                   int[] secondSortedArray,
                                   int sum) {
        assertThat(sumFinder.findSum(firstSortedArray, secondSortedArray, sum),
                is(false));
    }

    @Test
    @Parameters(method = "notFindSum")
    public void itShouldNotFindSum2(int[] firstSortedArray,
                                    int[] secondSortedArray,
                                    int sum) {
        assertThat(sumFinder.findSum2(firstSortedArray, secondSortedArray, sum),
                is(false));
    }

    private Object[][] notFindSum() {
        return new Object[][]{
                {new int[]{}, new int[]{}, 3},
                {new int[]{1}, new int[]{}, 1},
                {new int[]{}, new int[]{2}, 2},
                {new int[]{1, 2, 3}, new int[]{4, 5, 6}, 10}
        };
    }

}
