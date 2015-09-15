package math1.bit.xor;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Given n pairs of integers.
 * One number has got lost.
 * Find that number.
 */
@RunWith(JUnitParamsRunner.class)
public class LostNumberTest {

    @Test
    @Parameters(method = "data")
    public void itShouldFindLostNumber(int[] numbers, int lostNumber) {
        assertThat(findLostNumber(numbers), is(lostNumber));
    }

    Object[][] data() {
        return new Object[][]{
                {new int[]{1}, 1},
                {new int[]{1, 2, 1}, 2},
                {new int[]{1, 2, 2}, 1},
                {new int[]{1, 2, 3, 4, 4, 1, 2}, 3}
        };
    }

    private int findLostNumber(int[] numbers) {
        // x | y | r
        // 0 | 0 | 0
        // 0 | 1 | 1
        // 1 | 0 | 1
        // 1 | 1 | 0

        // [1, 2, 1]
        // e   acc
        //     00
        // 01  01
        // 10  11
        // 01  10 = 2

        int acc = 0;

        for (int n : numbers) {
            acc = acc ^ n;
        }

        return acc;
    }

}
