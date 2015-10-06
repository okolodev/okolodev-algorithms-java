package meetup_06_stack_queue_dynamic_array;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import stack1.adt.Stack;

/**
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/">Implement Stack using Queues</a>
 */
public class StackUsingQueues<E> implements Stack<E> {
    private Queue<E> queue = new LinkedQueue<>();

    @Override
    public void push(E element) {
        Queue<E> tmpQueue = new LinkedQueue<>();
        tmpQueue.enqueue(element);

        while (!queue.isEmpty()) {
            tmpQueue.enqueue(queue.dequeue());
        }

        queue = tmpQueue;
    }

    @Override
    public E pop() {
        return queue.dequeue();
    }

    @Override
    public E peek() {
        return queue.peek();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }

}
