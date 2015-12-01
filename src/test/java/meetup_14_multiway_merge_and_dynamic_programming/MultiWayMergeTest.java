package meetup_14_multiway_merge_and_dynamic_programming;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@Ignore
@RunWith(JUnitParamsRunner.class)
public class MultiWayMergeTest {
    private MultiWayMerge<Integer> merger = new MultiWayMerge<>();

    @Test
    @Parameters(method = "data")
    public void itShouldMultiWayMerge(Integer[][] arrays, Integer[] merged) {
        assertThat(merger.merge(arrays), is(merged));
    }

    private Object[][] data() {
        return new Object[][]{
                {new Integer[][]{}, new Integer[]{}},

                {new Integer[][]{{}}, new Integer[]{}},

                {new Integer[][]{{}, {1}, {}, {0}, {}}, new Integer[]{0, 1}},

                {new Integer[][]{{1, 4, 5}, {0, 3}, {2, 3, 4}},
                        new Integer[]{0, 1, 2, 3, 3, 4, 4, 5}},

                {new Integer[][]{{8, 10, 12}, {3, 5, 7}, {0, 1, 2}, {4, 6}, {9, 11, 13}},
                        new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13}}
        };
    }

}
