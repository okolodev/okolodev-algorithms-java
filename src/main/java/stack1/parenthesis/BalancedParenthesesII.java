package stack1.parenthesis;

import stack1.adt.ArrayStack;
import stack1.adt.Stack;

/**
 * <h2>20 Valid Parentheses</h2>
 * <p>
 * Given a string containing just the characters <code>'('</code>, <code>')'</code>,
 * <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine
 * if the input string is valid.
 * </p>
 * <p>
 * The brackets must close in the correct order, <code>"()"</code> and
 * <code>"()[]{}"</code> are all valid but <code>"(]"</code> and
 * <code>"([)]"</code> are not.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/valid-parentheses/">20 Valid Parentheses</a>
 */
public class BalancedParenthesesII {

    public boolean isValid(String parentheses) {
        Stack<Character> openStack = new ArrayStack<>(parentheses.length());

        for (Character symbol : parentheses.toCharArray()) {
            if (symbol == '('
                    || symbol == '{'
                    || symbol == '[') {
                openStack.push(symbol);
            } else if (openStack.isEmpty()) {
                return false;
            } else if (symbol == ')') {
                if (openStack.pop() != '(') {
                    return false;
                }
            } else if (symbol == '}') {
                if (openStack.pop() != '{') {
                    return false;
                }
            } else if (symbol == ']') {
                if (openStack.pop() != '[') {
                    return false;
                }
            }
        }

        return openStack.isEmpty();
    }

}
