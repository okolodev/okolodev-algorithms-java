package meetup_11_sorting;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class AbstractSortTest<E extends Comparable<E>> {
    private Sort<E> sort = createSort();

    protected abstract Sort<E> createSort();

    @Test
    @Parameters(method = "data")
    public void itShouldSort(E[] elements, E[] sortedElements) {
        assertThat(sort.sort(elements), is(sortedElements));
    }

    private Object[][] data() {
        return new Object[][]{
                {new Integer[]{}, new Integer[]{}},
                {new Integer[]{0}, new Integer[]{0}},

                {new Integer[]{2, 1}, new Integer[]{1, 2}},
                {new Integer[]{1, 2}, new Integer[]{1, 2}},
                {new Integer[]{1, 1}, new Integer[]{1, 1}},

                {new Integer[]{2, 3, 1}, new Integer[]{1, 2, 3}},
                {new Integer[]{1, 2, 3}, new Integer[]{1, 2, 3}},
                {new Integer[]{3, 2, 1}, new Integer[]{1, 2, 3}},
                {new Integer[]{3, 3, 1}, new Integer[]{1, 3, 3}},

                {new Integer[]{4, 2, 3, 1}, new Integer[]{1, 2, 3, 4}},
                {new Integer[]{1, 2, 3, 4}, new Integer[]{1, 2, 3, 4}},
                {new Integer[]{4, 3, 2, 1}, new Integer[]{1, 2, 3, 4}},
                {new Integer[]{4, 3, 4, 1}, new Integer[]{1, 3, 4, 4}},

                {new Integer[]{4, 2, 5, 3, 1}, new Integer[]{1, 2, 3, 4, 5}},
                {new Integer[]{1, 2, 3, 4, 5}, new Integer[]{1, 2, 3, 4, 5}},
                {new Integer[]{5, 4, 3, 2, 1}, new Integer[]{1, 2, 3, 4, 5}},
                {new Integer[]{5, 4, 5, 5, 2}, new Integer[]{2, 4, 5, 5, 5}},

                {new Integer[]{4, 6, 2, 5, 3, 1}, new Integer[]{1, 2, 3, 4, 5, 6}},
                {new Integer[]{1, 2, 3, 4, 5, 6}, new Integer[]{1, 2, 3, 4, 5, 6}},
                {new Integer[]{6, 5, 4, 3, 2, 1}, new Integer[]{1, 2, 3, 4, 5, 6}},
                {new Integer[]{6, 6, 6, 6, 3, 6}, new Integer[]{3, 6, 6, 6, 6, 6}},

                {new Integer[]{7, 4, 6, 2, 5, 3, 1},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7}},
                {new Integer[]{1, 2, 3, 4, 5, 6, 7},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7}},
                {new Integer[]{7, 6, 5, 4, 3, 2, 1},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7}},
                {new Integer[]{7, 6, 7, 4, 4, 5, 7},
                        new Integer[]{4, 4, 5, 6, 7, 7, 7}},

                {new Integer[]{7, 4, 8, 6, 2, 5, 3, 1},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {new Integer[]{8, 7, 6, 5, 4, 3, 2, 1},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8}},
                {new Integer[]{8, 6, 5, 8, 4, 8, 5, 8},
                        new Integer[]{4, 5, 5, 6, 8, 8, 8, 8}},

                {new Integer[]{7, 4, 8, 6, 2, 5, 9, 3, 1},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new Integer[]{9, 8, 7, 6, 5, 4, 3, 2, 1},
                        new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}},
                {new Integer[]{6, 9, 4, 3, 4, 7, 9, 9, 1},
                        new Integer[]{1, 3, 4, 4, 6, 7, 9, 9, 9}},

                {new Character[]{'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E'},
                        new Character[]{'A', 'E', 'E', 'L', 'M', 'O', 'P', 'R', 'S', 'T', 'X'}}
        };
    }

}
