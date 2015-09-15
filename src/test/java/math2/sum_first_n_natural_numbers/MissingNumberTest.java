package math2.sum_first_n_natural_numbers;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MissingNumberTest {

    @Test
    @Parameters(method = "data")
    public void itShouldFindMissingNumber(int[] numbers, int missingNumber) {
        assertThat(findMissingNumber(numbers), is(missingNumber));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{}, 0},

                {new int[]{0}, 1},
                {new int[]{1}, 0},

                {new int[]{0, 2}, 1},
                {new int[]{0, 1}, 2},
                {new int[]{2, 1}, 0},

                {new int[]{0, 2, 3}, 1},
                {new int[]{0, 2, 1}, 3},
                {new int[]{0, 3, 1}, 2},
                {new int[]{2, 3, 1}, 0}
        };
    }

    private int findMissingNumber(int[] numbers) {
        int n = numbers.length;
        int sum = n * (n + 1) / 2;

        for (int i : numbers) {
            sum = sum - i;
        }

        return sum;
    }

}
