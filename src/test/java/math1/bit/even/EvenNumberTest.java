package math1.bit.even;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


/**
 * Check if a specified integer represents a power of 2.
 */
@RunWith(JUnitParamsRunner.class)
public class EvenNumberTest {

    @Test
    @Parameters({
            "1, true",
            "2, true",
            "4, true",
            "8, true",
            "64, true",
            "128, true",
            "1024, true",

            "0, false",
            "3, false",
            "5, false",
            "10, false",
            "12, false",
            "127, false",

            "-1, false",
            "-2, false",
            "-3, false",
            "-4, false",
            "-1024, false"
    })
    public void itShouldCheckIfPowerOfTwo(int n, boolean power) {
        assertThat(isPowerOfTwo(n), is(power));
    }

    private boolean isPowerOfTwo(int n) {
        throw new UnsupportedOperationException("Implement me!");
    }

}
