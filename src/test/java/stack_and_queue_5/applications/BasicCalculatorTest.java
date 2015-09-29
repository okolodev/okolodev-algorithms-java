package stack_and_queue_5.applications;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BasicCalculatorTest {
    private BasicCalculator calculator = new BasicCalculator();

    @Test
    @Parameters(method = "expressions")
    public void itShouldEvaluateExpression(String[] tokens, int result) {
        assertThat(Arrays.toString(tokens),
                calculator.evaluate(tokens), is(result));
    }

    private Object[][] expressions() {
        return new Object[][]{
                {new String[]{"1", "+", "2"}, 3},

                {new String[]{"6", "-", "5"}, 1},

                {new String[]{"4", "*", "3"}, 12},

                {new String[]{"6", "/", "2"}, 3},
                {new String[]{"5", "/", "3"}, 1},

                {new String[]{"2", "+", "3", "*", "4", "-", "1"}, 13},
                {new String[]{"2", "+", "(", "3", "*", "4", ")", "-", "1"}, 13},
                {new String[]{"(", "2", "+", "3", ")", "*", "4", "-", "1"}, 19},
                {new String[]{"(", "2", "+", "3", ")", "*", "4", "/", "2"}, 10},

                {new String[]{"(", "1", "+", "(", "4", "+", "5", "+", "2", ")",
                        "-", "3", ")", "+", "(", "6", "+", "8", ")"}, 23}
        };
    }

}
