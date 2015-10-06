package meetup_06_stack_queue_dynamic_array;

import meetup_05_stack_and_queue.adt.Queue;
import stack1.adt.LinkedStack;
import stack1.adt.Stack;

/**
 * @see <a href="https://leetcode.com/problems/implement-queue-using-stacks/">Implement Queue using Stacks</a>
 */
public class QueueUsingStacks<E> implements Queue<E> {
    private Stack<E> in = new LinkedStack<>();
    private Stack<E> out = new LinkedStack<>();

    @Override
    public void enqueue(E element) {
        in.push(element);
    }

    @Override
    public E dequeue() {
        fillInOutStackIfEmpty();

        return out.pop();
    }

    @Override
    public E peek() {
        fillInOutStackIfEmpty();

        return out.peek();
    }

    private void fillInOutStackIfEmpty() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }

    }

    @Override
    public boolean isEmpty() {
        return out.isEmpty() && in.isEmpty();
    }

    @Override
    public int size() {
        return out.size() + in.size();
    }

}
