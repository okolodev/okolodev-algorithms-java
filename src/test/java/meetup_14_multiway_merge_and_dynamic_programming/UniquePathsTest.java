package meetup_14_multiway_merge_and_dynamic_programming;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UniquePathsTest {
    private UniquePaths pathsCounter = new UniquePaths();

    @Test
    @Parameters(method = "data")
    public void itShouldCountUniquePaths(int n, int m, int uniquePaths) {
        assertThat(pathsCounter.uniquePaths(n, m), is(uniquePaths));
    }

    private Object[][] data() {
        return new Object[][]{
                {1, 1, 1},

                {1, 2, 1},
                {2, 2, 2},
                {2, 1, 1},

                {1, 3, 1},
                {2, 3, 3},
                {3, 3, 6},
                {3, 2, 3},
                {3, 1, 1},

                {1, 4, 1},
                {2, 4, 4},
                {3, 4, 10},
                {4, 4, 20},
                {4, 3, 10},
                {4, 2, 4},
                {4, 1, 1},
        };
    }

}
