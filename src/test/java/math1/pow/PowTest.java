package math1.pow;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Compute n-th power of x.
 */
@RunWith(JUnitParamsRunner.class)
public class PowTest {

    @Test
    @Parameters({
            "2, 0, 1",
            "2, 1, 2",
            "2, 2, 4",
            "2, 3, 8",
            "2, 4, 16",
            "2, 5, 32",

            "3, 3, 27",
            "4, 2, 16",

            "2, -1, 0.5",
            "2, -2, 0.25",
            "2, -3, 0.125"
    })
    public void itShouldPow(double x, int n, double result) {
        assertThat(pow(x, n), is(result));
    }

    private double pow(double x, int n) {
        throw new UnsupportedOperationException("Implement me!");
    }

}
