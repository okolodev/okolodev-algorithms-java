package math2.bit.xor;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SingleNumberIITest {

    @Test
    @Parameters(method = "data")
    public void itShouldFindSingleNumber(int[] numbers, int single) {
        assertThat(findSingleNumber(numbers), is(single));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{5}, 5},
                {new int[]{1, 1, 2, 1}, 2},
                {new int[]{1, 1, 1, 2}, 2},
                {new int[]{2, 1, 1, 2, 3, 1, 2}, 3},
                {new int[]{2, 1, 2, 1, 4, 3, 2, 3, 1, 3}, 4}
        };
    }

    private int findSingleNumber(int[] numbers) {
        throw new UnsupportedOperationException("Implement me!");
    }

}
