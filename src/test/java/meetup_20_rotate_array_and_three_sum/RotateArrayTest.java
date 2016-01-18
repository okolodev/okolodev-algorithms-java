package meetup_20_rotate_array_and_three_sum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RotateArrayTest {
    private RotateArray rotator = new RotateArray();

    @Test
    @Parameters(method = "arrays")
    public void itShouldRotateArray(int[] numbers,
                                    int positions,
                                    int[] rotatedNumbers) {
        rotator.rotate(numbers, positions);

        assertThat(numbers, is(rotatedNumbers));
    }

    @Test
    @Parameters(method = "arrays")
    public void itShouldRotateArray2(int[] numbers,
                                     int positions,
                                     int[] rotatedNumbers) {
        rotator.rotate2(numbers, positions);

        assertThat(numbers, is(rotatedNumbers));
    }

    @Test
    @Parameters(method = "arrays")
    public void itShouldRotateArray3(int[] numbers,
                                     int positions,
                                     int[] rotatedNumbers) {
        rotator.rotate3(numbers, positions);

        assertThat(numbers, is(rotatedNumbers));
    }

    @Test
    @Parameters(method = "arrays")
    public void itShouldRotateArray4(int[] numbers,
                                     int positions,
                                     int[] rotatedNumbers) {
        rotator.rotate4(numbers, positions);

        assertThat(numbers, is(rotatedNumbers));
    }

    @Test
    @Parameters(method = "arrays")
    public void itShouldRotateArray5(int[] numbers,
                                     int positions,
                                     int[] rotatedNumbers) {
        rotator.rotate5(numbers, positions);

        assertThat(numbers, is(rotatedNumbers));
    }

    @Test
    @Parameters(method = "arrays")
    public void itShouldRotateArray6(int[] numbers,
                                     int positions,
                                     int[] rotatedNumbers) {
        rotator.rotate6(numbers, positions);

        assertThat(numbers, is(rotatedNumbers));
    }

    private Object[][] arrays() {
        return new Object[][]{
                {new int[]{}, 5, new int[]{}},

                {new int[]{1}, 0, new int[]{1}},
                {new int[]{1}, 1, new int[]{1}},

                {new int[]{1, 2}, 1, new int[]{2, 1}},
                {new int[]{1, 2}, 2, new int[]{1, 2}},
                {new int[]{1, 2}, 3, new int[]{2, 1}},

                {new int[]{1, 2, 3, 4, 5, 6, 7}, 0, new int[]{1, 2, 3, 4, 5, 6, 7}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 1, new int[]{7, 1, 2, 3, 4, 5, 6}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 2, new int[]{6, 7, 1, 2, 3, 4, 5}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 4, new int[]{4, 5, 6, 7, 1, 2, 3}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 5, new int[]{3, 4, 5, 6, 7, 1, 2}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 6, new int[]{2, 3, 4, 5, 6, 7, 1}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 7, new int[]{1, 2, 3, 4, 5, 6, 7}},
                {new int[]{1, 2, 3, 4, 5, 6, 7}, 8, new int[]{7, 1, 2, 3, 4, 5, 6}}
        };
    }

}
