package math1.bit.length;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Find length of bits for a specified positive integer.
 */
@RunWith(JUnitParamsRunner.class)
public class NumberBitLengthTest {

    @Test
    @Parameters({
            "0, 1",
            "1, 1",
            "2, 2",
            "3, 2",
            "4, 3",
            "5, 3",
            "8, 4",
            "16, 5",
            "31, 5",
            "32, 6",
            "1023, 10",
            "1024, 11"
    })
    public void itShouldFindNumberOfBitsToRepresentAnInteger(int n, int bits) {
        assertThat(numberOfBits(n), is(bits));
    }

    private int numberOfBits(int n) {
        throw new UnsupportedOperationException("Implement me!");
    }

}
