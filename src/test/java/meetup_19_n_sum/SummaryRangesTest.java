package meetup_19_n_sum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmytro Chyzhykov.
 */
@RunWith(JUnitParamsRunner.class)
public class SummaryRangesTest {
    private SummaryRanges summaryRanges = new SummaryRanges();

    @Test
    @Parameters(method = "data")
    public void itShouldConvertToSummaryRanges(int[] numbers, DynamicList<String> ranges) {
        assertThat(summaryRanges.summaryRanges(numbers), is(ranges));
    }

    private Object[][] data() {
        return new Object[][]{
                {new int[]{}, toList()},

                {new int[]{5}, toList("5")},
                {new int[]{1, 2, 3, 4, 5}, toList("1->5")},
                {new int[]{0, 1, 2, 4, 5, 7}, toList("0->2", "4->5", "7")},
                {new int[]{12, 13, 81, 82, 83, 84, 86, 87, 88},
                        toList("12->13", "81->84", "86->88")}
        };
    }

    private <E> DynamicList<E> toList(E... elements) {
        return new ArrayDynamicList<>(elements);
    }

}
