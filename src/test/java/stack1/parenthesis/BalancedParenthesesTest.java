package stack1.parenthesis;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BalancedParenthesesTest {
    private BalancedParentheses validator = new BalancedParentheses();

    @Test
    @Parameters({
            "",
            "()",
            "()()",
            "(())()",
            "(()()()())",
            "(((())))",
            "(()((())()))"
    })
    public void itShouldValidParenthesis(String parenthesis) {
        assertThat(validator.isValid(parenthesis), is(true));
    }

    @Test
    @Parameters({
            "(",
            ")",
            ")(",
            "()(",
            "())",
            "((((((())",
            "()))",
            "(()()(()"
    })
    public void itShouldInvalidParenthesis(String parenthesis) {
        assertThat(validator.isValid(parenthesis), is(false));
    }

}
