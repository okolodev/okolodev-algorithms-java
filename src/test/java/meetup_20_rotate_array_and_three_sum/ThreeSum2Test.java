package meetup_20_rotate_array_and_three_sum;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ThreeSum2Test {
    private ThreeSum2 threeSum = new ThreeSum2();

    @Test
    @Parameters(method = "data")
    public void itShouldAllFindAllTripletsSummingToZeroInCorrectOrder(
            Integer[] numbers,
            DynamicList<DynamicList<Integer>> triplets) {
        assertThat(threeSum.threeSum(numbers), is(triplets));
    }

    private Object[][] data() {
        return new Object[][]{
                {new Integer[]{0, 0, 0}, toList(toList(0, 0, 0))},

                {new Integer[]{-2, -1, 3}, toList(toList(-2, -1, 3))},
                {new Integer[]{3, -1, -2}, toList(toList(-2, -1, 3))},

                {new Integer[]{-5, 10, -5, 0}, toList(toList(-5, -5, 10))},
                {new Integer[]{-5, 0, 10, -5, 0, 0}, toList(toList(-5, -5, 10), toList(0, 0, 0))},

                {new Integer[]{-1, 0, 1, 2, -1, -4},
                        toList(toList(-1, -1, 2), toList(-1, 0, 1))},
                {new Integer[]{8, 14, -1, -22, 23, 12, -20},
                        toList(toList(-22, -1, 23),
                                toList(-22, 8, 14),
                                toList(-20, 8, 12))},

                {new Integer[]{3, -1, -2, -1, -1, -2, -2, 3},
                        toList(toList(-2, -1, 3))},
        };
    }

    private <E> DynamicList<E> toList(E... elements) {
        return new ArrayDynamicList<>(elements);
    }

}
