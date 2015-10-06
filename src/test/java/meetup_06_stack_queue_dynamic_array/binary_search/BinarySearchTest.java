package meetup_06_stack_queue_dynamic_array.binary_search;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BinarySearchTest {
    private BinarySearch searcher = new BinarySearch();

    @Test
    @Parameters(method = "data")
    public void itShouldPerformBinarySearchRecursively(char[] array,
                                                       char key,
                                                       int index) {
        assertThat(searcher.recursiveBinarySearch(array, key), is(index));
    }

    @Test
    @Parameters(method = "data")
    public void itShouldPerformBinarySearchIteratively(char[] array,
                                                       char needle,
                                                       int key) {
        assertThat(searcher.iterativeBinarySearch(array, needle), is(key));
    }

    private Object[][] data() {
        return new Object[][]{
                {new char[]{'b'}, 'b', 0},
                {new char[]{'b'}, 'a', -1},
                {new char[]{'b'}, 'c', -2},

                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'a', 0},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'b', -2},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'c', 1},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'd', -3},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'e', 2},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'f', -4},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'g', 3},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'h', -5},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'i', 4},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'j', -6},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'k', 5},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'l', -7},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'm', 6},
                {new char[]{'a', 'c', 'e', 'g', 'i', 'k', 'm'}, 'n', -8},
        };
    }

}
