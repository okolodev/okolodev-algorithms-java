package meetup_05_stack_and_queue.applications;

import stack1.adt.LinkedStack;
import stack1.adt.Stack;

/**
 * <p>
 * Support the minimum element in a stack in constant time.
 * </p>
 *
 * @see <a href="https://leetcode.com/problems/min-stack/">Min Stack</a>
 */
public class MinStack {
    private Stack<Integer> stack = new LinkedStack<>();
    private Stack<Integer> minimum = new LinkedStack<>();

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void push(int element) {
        stack.push(element);

        if (minimum.isEmpty()) {
            minimum.push(element);
        } else if (element <= minimum.peek()) {
            minimum.push(element);
        }
    }

    public int pop() {
        if (stack.peek() == minimum.peek()) {
            minimum.pop();
        }

        return stack.pop();
    }

    public int peek() {
        return stack.peek();
    }

    public int getMin() {
        return minimum.peek();
    }

}
