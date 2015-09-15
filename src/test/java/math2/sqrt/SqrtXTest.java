package math2.sqrt;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SqrtXTest {

    @Test
    @Parameters({
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",

            "2147395599",
            "2147483647"
    })
    public void itShouldCalculateSquareRoot(double x) {
        assertThat(sqrt(x), is(closeTo(Math.sqrt(x), 1e-5)));
    }

    private double sqrt(double x) {
        double guess = 1;

        while (!isGoodEnough(guess, x)) {
            guess = guess(guess, x);
        }

        return guess;
    }

    private boolean isGoodEnough(double guess, double x) {
        return Math.abs(guess * guess - x) / x < 1e-10;
    }

    private double guess(double guess, double x) {
        return (guess + x / guess) / 2;
    }

}
