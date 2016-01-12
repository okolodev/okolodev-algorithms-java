package meetup_19_n_sum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import junitparams.naming.TestCaseName;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TwoSumTest {
    private TwoSum twoSum = new TwoSum();

    @Test
    @Parameters(method = "singleSolution")
    @TestCaseName("{params}")
    public void itShouldFindIndicesSummingToTargetForSingeSolution(int[] numbers,
                                                                   int target,
                                                                   int[] indices
    ) {
        assertThat(twoSum.twoSum(numbers, target), is(indices));
    }


    private Object[][] singleSolution() {
        return new Object[][]{
                {new int[]{0, 0}, 0, new int[]{1, 2}},
                {new int[]{1, -1}, 0, new int[]{1, 2}},
                {new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}},
                {new int[]{15, 7, 11, 2}, 9, new int[]{2, 4}},
                {new int[]{1, 2, 3, 4, 5}, 8, new int[]{3, 5}},
                {new int[]{3, 2, 4}, 6, new int[]{2, 3}},
        };
    }

    @Test
    @Parameters(method = "multiSolutionFirstSolution")
    public void itShouldFindIndicesSummingToTargetForMultiSolutionFirstSolution(
            int[] numbers,
            int target,
            int[] indices
    ) {
        assertThat(twoSum.twoSum(numbers, target), is(indices));
    }

    private Object[][] multiSolutionFirstSolution() {
        return new Object[][]{
                {new int[]{1, 1, 1, 1, 4}, 5, new int[]{1, 5}},
                {new int[]{4, 3, 9, 4, 0, 1, 8, 1, 1}, 5, new int[]{1, 6}},
                {new int[]{3, 4, 9, 4, 0, 1, 8, 1, 1}, 5, new int[]{2, 6}},
        };
    }

}
