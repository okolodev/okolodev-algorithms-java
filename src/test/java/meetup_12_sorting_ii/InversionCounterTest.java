package meetup_12_sorting_ii;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class InversionCounterTest<E extends Comparable<E>> {
    private InversionCounter<E> inversionCounter = new InversionCounter<>();

    @Test
    @Parameters(method = "data")
    public void itShouldCountInversions(E[] elements, int inversions) {
        assertThat(inversionCounter.countInversions(elements), is(inversions));
    }

    private Object[][] data() {
        return new Object[][]{
                {new Integer[]{}, 0},
                {new Integer[]{0}, 0},
                {new Integer[]{1}, 0},
                {new Integer[]{1, 2}, 0},
                {new Integer[]{1, 2, 3}, 0},
                {new Integer[]{1, 2, 3, 4}, 0},
                {new Integer[]{1, 2, 3, 4, 5}, 0},
                {new Integer[]{1, 2, 3, 4, 5, 6}, 0},

                {new Integer[]{-5, -2, 0, 2, 10, 11}, 0},
                {new Integer[]{1, 1, 1, 1, 2}, 0},

                {new Integer[]{2, 1}, 1},
                {new Integer[]{6, 5, 4, 3, 2, 1}, 15},
                {new Integer[]{1, 2, 2, 9, 5, 4}, 3},
                {new Integer[]{1, 2, 7, 3, 6}, 2}
        };
    }

}
