package stack1.parenthesis;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BalancedParenthesesIITest {
    private BalancedParenthesesII validator = new BalancedParenthesesII();


    @Test
    @Parameters({
            ",         true",
            "(,        false",
            "),        false",
            "[,        false",
            "],        false",
            "{,        false",
            "},        false",
            "(),       true",
            ")(,       false",
            "[},       false",
            "{[}],     false",
            "{}[](),   true",
            "([{}]),   true",
            "[()[]{}], true"
    })
    public void itShouldValidateParentheses(String parentheses, boolean valid) {
        assertThat(validator.isValid(parentheses), is(valid));
    }

}
