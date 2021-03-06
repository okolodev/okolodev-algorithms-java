package meetup_05_stack_and_queue.applications;


import stack1.adt.LinkedStack;
import stack1.adt.Stack;

/**
 * <p>
 * Evaluate Reverse Polish Notation
 * <pre><code>
 * ["3", "4", "+"] -> 3 + 4 -> 7
 * ["5", "3", "-"] -> 5 - 3 -> 2
 * ["2", "3", "*"] -> 2 * 3 -> 6
 * ["5", "2", "/"] -> 5 / 2 -> 2
 * <br />
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * </code></pre>
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Reverse Polish notation</a>
 * @see <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">150 Evaluate Reverse Polish Notation</a>
 */
public class ReversePolishNotation {

    public int evaluate(String[] tokens) {
        Stack<Integer> stack = new LinkedStack<>();

        for (String token : tokens) {
            if ("+-*/".contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                int result;

                if ("+".equals(token)) {
                    result = a + b;
                } else if ("-".equals(token)) {
                    result = a - b;
                } else if ("*".equals(token)) {
                    result = a * b;
                } else {
                    result = a / b;
                }

                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

}
