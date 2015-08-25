package math1.gcd;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Find the greatest common divisor of two numbers.
 */
@RunWith(JUnitParamsRunner.class)
public class GreatestCommonDivisorTest {

    @Test
    @Parameters({
            "2, 4, 2",
            "33, 22, 11",

            "3, 5, 1",
            "11, 19, 1",

            "0, 4, 4",
            "4, 0, 4",

            "15015, 62985, 195"
    })
    public void itShouldFindGreatestCommonDivisor(int a, int b, int gcd) {
        assertThat(gcd(a, b), is(gcd));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

}
