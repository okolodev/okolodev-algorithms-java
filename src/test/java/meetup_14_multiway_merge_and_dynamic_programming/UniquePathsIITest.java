package meetup_14_multiway_merge_and_dynamic_programming;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class UniquePathsIITest {
    private UniquePathsII pathsCounter = new UniquePathsII();

    @Test
    @Parameters(method = "data")
    public void itShouldCountUniquePathsOnAGridWithObstacles(int[][] obstacleGrid,
                                                             int uniquePaths) {
        assertThat(pathsCounter.uniquePathsWithObstacles(obstacleGrid), is(uniquePaths));
    }

    private Object[][] data() {
        return new Object[][]{
                {
                        new int[][]{}, 0
                },
                {
                        new int[][]{{}}, 0
                },
                {
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {0, 0, 0}
                        }, 2
                },
                {
                        new int[][]{
                                {0, 0, 0},
                                {0, 1, 0},
                                {1, 0, 0}
                        }, 1
                },
                {
                        new int[][]{
                                {0, 0, 1},
                                {0, 1, 0},
                                {1, 0, 0}
                        }, 0
                },
                {
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 1}
                        }, 0
                },
                {
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0},
                                {1, 0, 0}
                        }, 5
                },
                {
                        new int[][]{
                                {0, 0, 0},
                                {0, 0, 0},
                                {0, 0, 0}
                        }, 6
                }
        };
    }


}
