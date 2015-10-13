package meetup_07_arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ContainsDuplicateTest {
    private ContainsDuplicate duplicateChecker = new ContainsDuplicate();

    @Test
    @Parameters(method = "data")
    public void itShouldCheckIfArrayContainsDuplicate(int[] numbers, boolean contains) {
        String reason = Arrays.toString(numbers) + " contains duplicates? " + contains;

        assertThat(reason, duplicateChecker.containsDuplicate(numbers), is(contains));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{}, false},
                {new int[]{1}, false},
                {new int[]{2, 1}, false},
                {new int[]{3, 1, 2}, false},

                {new int[]{0, 0}, true},
                {new int[]{0, 2, 3, 2}, true},
                {new int[]{1, 3, 3, 2, 1}, true}
        };
    }

}
