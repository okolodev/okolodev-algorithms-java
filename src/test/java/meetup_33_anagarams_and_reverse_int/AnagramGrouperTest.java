package meetup_33_anagarams_and_reverse_int;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class AnagramGrouperTest {
    private AnagramGrouper grouper = new AnagramGrouper();

    @Test
    @Parameters(method = "data")
    public void itShouldGroupAnagrams(String[] words, List<List<Integer>> expectedAnagrams) {
        assertThat(grouper.groupAnagrams(words), is(expectedAnagrams));
    }

    private Object[][] data() {
        return new Object[][]{
                {new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        asList(
                                asList("ate", "eat", "tea"),
                                asList("bat"),
                                asList("nat", "tan")
                        )
                },
                {new String[]{"coffee", "tar", "quite", "tea", "bark", "quiet", "rat"},
                        asList(
                                asList("bark"),
                                asList("coffee"),
                                asList("quiet", "quite"),
                                asList("rat", "tar"),
                                asList("tea")
                        )
                }
        };
    }

}
