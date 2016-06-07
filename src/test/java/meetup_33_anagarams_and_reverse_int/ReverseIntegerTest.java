package meetup_33_anagarams_and_reverse_int;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ReverseIntegerTest {
    private ReverseInteger reverser = new ReverseInteger();

    @Test
    @Parameters({
            "123, 321",
            "-123, -321",
            "10, 1",
            "100, 1",
            "1000000003, 0",
            "0, 0",
            "1534236469, 0"
    })
    public void itShouldReverseInteger(int original, int reversed) {
        assertThat(reverser.reverse(original), is(reversed));
    }

    @Test
    @Parameters({
            "123, 321",
            "-123, -321",
            "10, 1",
            "100, 1",
            "1000000003, 0",
            "0, 0",
            "1534236469, 0"
    })
    public void itShouldReverseInteger2(int original, int reversed) {
        assertThat(reverser.reverse2(original), is(reversed));
    }

}
