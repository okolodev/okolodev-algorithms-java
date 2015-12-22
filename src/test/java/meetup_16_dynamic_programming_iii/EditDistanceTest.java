package meetup_16_dynamic_programming_iii;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class EditDistanceTest {
    private EditDistance editDistance = new EditDistance();

    @Test
    @Parameters(method = "words")
    public void itShouldFindEditDistance(String word1, String word2,
                                         int minDistance) {
        assertThat(editDistance.minDistance(word1, word2), is(minDistance));
    }

    private Object[][] words() {
        return new Object[][]{
                {"", "", 0},
                {"cat", "cat", 0},
                {"cat", "", 3},
                {"", "dog", 3},
                {"cat", "cut", 1},
                {"a", "aa", 1},
                {"ba", "ab", 2},
                {"intention", "execution", 5},
                {"sausage", "sausage", 0},
                {"abcde", "fhijk", 5}
        };
    }

}
