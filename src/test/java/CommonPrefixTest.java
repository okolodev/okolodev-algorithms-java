import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dmytro Chyzhykov.
 */
@RunWith(JUnitParamsRunner.class)
public class CommonPrefixTest {

    @Test
    @Parameters(method = "data")
    public void itShouldFindCommonPrefix(String[] strings, String commonPrefix) {
        assertThat(commonPrefix(strings), is(commonPrefix));
    }

    private Object[][] data() {
        return new Object[][]{
                {new String[]{}, ""},
                {new String[]{"str1", "str2", "str3"}, "str"},
                {new String[]{"str1", "str2", "ha-ha-ha"}, ""},
                {new String[]{"str1", "str2", ""}, ""}
        };
    }

    private String commonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }

        Arrays.sort(strings, (a, b) -> Integer.compare(a.length(), b.length()));

        return strings[0].substring(0, commonPrefixLength(strings, 0));
    }

    private int commonPrefixLength(String[] strings, int length) {
        String shortestString = strings[0];

        if (shortestString.length() == length) {
            return length;
        }

        char symbol = shortestString.charAt(length);

        for (String string : strings) {
            if (string.charAt(length) != symbol) {
                return length;
            }
        }

        return commonPrefixLength(strings, length + 1);
    }

}
