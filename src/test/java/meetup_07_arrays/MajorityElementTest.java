package meetup_07_arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class MajorityElementTest {
    private MajorityElement majority = new MajorityElement();

    @Test
    @Parameters(method = "data")
    public void itShouldFindMajorityElement(int[] elements, int majorityElement) {
        String reason = Arrays.toString(elements) + " has as the majority " + majorityElement;

        assertThat(reason, majority.majorityElement(elements), is(majorityElement));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{1}, 1},

                {new int[]{2, 2, 1}, 2},
                {new int[]{2, 1, 2}, 2},
                {new int[]{1, 2, 2}, 2},

                {new int[]{1, 1, 2}, 1},
                {new int[]{1, 2, 1}, 1},
                {new int[]{2, 1, 1}, 1},

                {new int[]{1, 3, 1, 3, 3, 2, 3, 2, 3}, 3}
        };
    }

}
