package meetup_05_stack_and_queue.applications;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ReversePolishNotationTest {
    private ReversePolishNotation rpn = new ReversePolishNotation();

    @Test
    @Parameters(method = "data")
    public void itShouldEvalRPN(String[] tokens, int result) {
        assertThat(rpn.evaluate(tokens), is(result));
    }

    private Object[][] data() {
        return new Object[][]{
                {new String[]{"3", "4", "+"}, 7},

                {new String[]{"5", "3", "-"}, 2},

                {new String[]{"2", "3", "*"}, 6},

                {new String[]{"5", "2", "/"}, 2},

                {new String[]{"2", "1", "+", "3", "*"}, 9},
                {new String[]{"4", "13", "5", "/", "+"}, 6}
        };
    }

}
