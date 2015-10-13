package meetup_07_arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class PlusOneTest {
    private PlusOne plusOne = new PlusOne();

    @Test
    @Parameters(method = "data")
    public void itShouldPlusOne(int[] digits, int[] plusOneDigits) {
        String reason = Arrays.toString(digits) + " + 1 = " + Arrays.toString(plusOneDigits);

        assertThat(reason, plusOne.plusOne(digits), is(plusOneDigits));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{0}, new int[]{1}},
                {new int[]{1}, new int[]{2}},
                {new int[]{9}, new int[]{1, 0}},

                {new int[]{5, 7}, new int[]{5, 8}},
                {new int[]{6, 8}, new int[]{6, 9}},
                {new int[]{7, 9}, new int[]{8, 0}},

                {new int[]{7, 9, 9}, new int[]{8, 0, 0}},
                {new int[]{9, 8, 9}, new int[]{9, 9, 0}},

                {new int[]{9, 9, 9}, new int[]{1, 0, 0, 0}}
        };
    }

}
