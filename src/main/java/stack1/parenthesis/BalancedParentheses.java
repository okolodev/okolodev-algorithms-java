package stack1.parenthesis;

/**
 * <p>
 * Balanced parentheses means that each opening symbol has a corresponding
 * closing symbol and the pairs of parentheses are properly nested.
 * </p>
 * <p>
 * Consider the following correctly balanced strings of parentheses:
 * <pre><code>
 * empty string
 * ()
 * ()()
 * (())()
 * (()()()())
 * (((())))
 * (()((())()))
 * </code></pre>
 * Compare those with the following, which are not balanced:
 * <pre><code>
 * ((((((())
 * ()))
 * (()()(()
 * </code></pre>
 * </p>
 */
public class BalancedParentheses {

    public boolean isValid(String parentheses) {
        int openCount = 0;

        for (Character symbol : parentheses.toCharArray()) {
            if (symbol == '(') {
                openCount++;
            } else if (openCount == 0) {
                return false;
            } else {
                openCount--;
            }
        }

        return openCount == 0;
    }

}
