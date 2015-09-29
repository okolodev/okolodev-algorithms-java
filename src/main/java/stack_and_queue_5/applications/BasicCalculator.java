package stack_and_queue_5.applications;

import stack1.adt.LinkedStack;
import stack1.adt.Stack;
import stack_and_queue_5.adt.LinkedQueue;
import stack_and_queue_5.adt.Queue;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Implement a basic calculator to evaluate a simple expression string.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/basic-calculator/">Basic Calculator</a>
 */
public class BasicCalculator {
    private static final Map<String, Integer> PRECEDENCE = new HashMap<>();

    static {
        PRECEDENCE.put("+", 0);
        PRECEDENCE.put("-", 0);
        PRECEDENCE.put("*", 1);
        PRECEDENCE.put("/", 1);
    }

    public int evaluate(String[] tokens) {
        Queue<String> outputQueue = new LinkedQueue<>();
        Stack<String> operatorStack = new LinkedStack<>();

        for (String token : tokens) {
            if ("(".equals(token)) {
                operatorStack.push(token);
            } else if (")".equals(token)) {
                while (!"(".equals(operatorStack.peek())) {
                    outputQueue.enqueue(operatorStack.pop());
                }

                operatorStack.pop();
            } else if ("+-*/".contains(token)) {
                while (!operatorStack.isEmpty()
                        && PRECEDENCE.containsKey(operatorStack.peek())
                        && PRECEDENCE.get(token) <= PRECEDENCE.get(operatorStack.peek())) {
                    outputQueue.enqueue(operatorStack.pop());
                }

                operatorStack.push(token);
            } else {
                outputQueue.enqueue(token);
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.enqueue(operatorStack.pop());
        }

        String[] rpn = new String[outputQueue.size()];
        for (int i = 0; i < rpn.length; i++) {
            rpn[i] = outputQueue.dequeue();
        }

        return new ReversePolishNotation().evaluate(rpn);
    }

}
