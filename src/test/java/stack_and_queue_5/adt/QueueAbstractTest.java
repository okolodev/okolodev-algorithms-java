package stack_and_queue_5.adt;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class QueueAbstractTest {
    protected Queue<Character> queue = createQueue();

    protected abstract Queue<Character> createQueue();

    @Test
    public void itShouldBeEmptyWhenCreated() {
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void itShouldNotBeEmptyWhenElementWasEnqueued() {
        queue.enqueue('A');

        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void itShouldDequeueEnqueuedElement() {
        char element = 'B';

        queue.enqueue(element);

        assertThat(queue.dequeue(), is(element));
    }


    @Test
    public void itShouldBeEmptyWhenSingleElementWasDequeued() {
        char element = 'C';

        queue.enqueue(element);
        queue.dequeue();


        assertThat(queue.isEmpty(), is(true));
    }

    // peek
    @Test
    public void itShouldPeekEnqueuedElement() {
        queue.enqueue('A');


        assertThat(queue.peek(), is('A'));
    }

    @Test
    public void peekingSingleElementShouldNotMakeQueueEmpty() {
        queue.enqueue('A');

        queue.peek();

        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void peekShouldBeIdempotent() {
        queue.enqueue('A');

        assertThat(queue.peek(), is(queue.peek()));
    }

    @Test
    public void itShouldIncreaseSizeWhenElementsEnqueued() {
        assertThat("Size mismatch", queue.size(), is(0));

        queue.enqueue('A');
        assertThat("Size mismatch", queue.size(), is(1));

        queue.enqueue('B');
        assertThat("Size mismatch", queue.size(), is(2));

        queue.enqueue('C');
        assertThat("Size mismatch", queue.size(), is(3));

        queue.enqueue('D');
        assertThat("Size mismatch", queue.size(), is(4));
    }

    @Test
    public void itShouldDecreaseSizeWhenElementsDequeued() {
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        queue.enqueue('D');

        assertThat("Size mismatch", queue.size(), is(4));

        queue.dequeue();
        assertThat("Size mismatch", queue.size(), is(3));

        queue.dequeue();
        assertThat("Size mismatch", queue.size(), is(2));

        queue.dequeue();
        assertThat("Size mismatch", queue.size(), is(1));

        queue.dequeue();
        assertThat("Size mismatch", queue.size(), is(0));
    }

    @Test
    public void itShouldDecreaseSizeIfElementPeeked() {
        queue.enqueue('A');

        queue.peek();

        assertThat(queue.size(), is(1));
    }

    @Test
    public void itShouldWorkFirstInFirstOut() {
        queue.enqueue('A');
        queue.enqueue('B');
        queue.enqueue('C');
        queue.enqueue('D');

        assertThat("Dequeued value mismatch", queue.dequeue(), is('A'));
        assertThat("Dequeued value mismatch", queue.dequeue(), is('B'));
        assertThat("Dequeued value mismatch", queue.dequeue(), is('C'));

        queue.enqueue('E');
        queue.enqueue('F');
        queue.enqueue('G');

        assertThat("Dequeued value mismatch", queue.dequeue(), is('D'));
        assertThat("Dequeued value mismatch", queue.dequeue(), is('E'));
        assertThat("Dequeued value mismatch", queue.dequeue(), is('F'));
        assertThat("Dequeued value mismatch", queue.dequeue(), is('G'));
    }

}
