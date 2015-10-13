package meetup_07_arrays;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class RemoveElementTest {
    private RemoveElement remover = new RemoveElement();

    @Test
    @Parameters(method = "data")
    public void itShouldRemoveElement(int[] numbers,
                                      int element,
                                      int length,
                                      int[] expectedNumbers) {
        assertThat("Length mismatch",
                remover.removeElement(numbers, element), is(length));
        assertThat("Contents mismatch", numbers, is(expectedNumbers));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{}, 0, 0, new int[]{}},

                {new int[]{1, 2, 3}, 4, 3, new int[]{1, 2, 3}},
                {new int[]{1, 2, 3}, 1, 2, new int[]{2, 3, 1}},
                {new int[]{1, 2, 3}, 3, 2, new int[]{1, 2, 3}},

                {new int[]{7, 7, 7, 7, 2, 7, 3}, 7, 2,
                        new int[]{2, 3, 7, 7, 7, 7, 7}},

                {new int[]{1, 2, 3, 2, 4, 2, 2, 5}, 2, 4,
                        new int[]{1, 3, 4, 5, 2, 2, 2, 2}}
        };
    }

}
