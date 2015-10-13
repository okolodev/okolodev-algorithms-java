package meetup_07_arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ContainsMajorityElementTest {
    private ContainsMajorityElement majority = new ContainsMajorityElement();

    @Test
    @Parameters(method = "majorityElementExists")
    public void itShouldCheckThatMajorityElementExistsPositively(int[] elements) {
        String reason = Arrays.toString(elements) + " contains the majority element";

        assertThat(reason, majority.containsMajorityElement(elements), is(true));
    }

    @Test
    @Parameters(method = "majorityElementDoesNotExist")
    public void itShouldCheckThatMajorityElementExistsNegatively(int[] elements) {
        String reason = Arrays.toString(elements) + " contains no majority element";

        assertThat(reason, majority.containsMajorityElement(elements), is(false));
    }

    private Object[][] majorityElementExists() {
        return new Object[][]{
                {new int[]{1}},

                {new int[]{2, 2, 1}},
                {new int[]{2, 1, 2}},
                {new int[]{1, 2, 2}},

                {new int[]{1, 1, 2}},
                {new int[]{1, 2, 1}},
                {new int[]{2, 1, 1}},

                {new int[]{1, 3, 1, 3, 3, 2, 3, 2, 3}},

                {new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3}}
        };
    }

    private Object[][] majorityElementDoesNotExist() {
        return new Object[][]{
                {new int[]{}},

                {new int[]{1, 2, 3}},
                {new int[]{3, 1, 2}},
                {new int[]{1, 3, 2}},

                {new int[]{1, 1, 2, 2, 3, 3, 3, 3}},
                {new int[]{1, 3, 1, 3, 3, 2, 3, 2}}
        };
    }

}
