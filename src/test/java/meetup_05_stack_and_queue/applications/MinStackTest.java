package meetup_05_stack_and_queue.applications;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MinStackTest {
    private MinStack minStack = new MinStack();

    @Test
    public void itShouldBeEmptyWhenCreated() {
        assertThat(minStack.isEmpty(), is(true));
    }

    @Test
    public void itShouldNotBeEmptyWhenAnElementWasAdded() {
        minStack.push(1);

        assertThat(minStack.isEmpty(), is(false));
    }

    @Test
    public void poppingSingleElementShouldMakeStackEmpty() {
        Integer element = 2;

        minStack.push(element);
        minStack.pop();

        assertThat(minStack.isEmpty(), is(true));
    }

    @Test
    public void itShouldPushAndPeekAndPopLikeStack() {
        minStack.push(4);
        minStack.push(1);
        minStack.push(3);
        minStack.push(2);

        assertThat("Peeked element mismatch", minStack.peek(), is(2));
        assertThat("Popped element mismatch", minStack.pop(), is(2));

        assertThat("Peeked element mismatch", minStack.peek(), is(3));
        assertThat("Popped element mismatch", minStack.pop(), is(3));

        assertThat("Peeked element mismatch", minStack.peek(), is(1));
        assertThat("Popped element mismatch", minStack.pop(), is(1));

        assertThat("Peeked element mismatch", minStack.peek(), is(4));
        assertThat("Peeked element mismatch", minStack.pop(), is(4));
    }

    @Test
    public void itShouldPushAndPopAndSupportGetMin() {
        minStack.push(8);
        minStack.push(5);
        minStack.push(6);
        minStack.push(4);
        minStack.push(3);
        minStack.push(9);
        minStack.push(2);
        minStack.push(7);
        minStack.push(2);
        minStack.push(6);

        assertThat("Min element mismatch", minStack.getMin(), is(2));
        minStack.pop();
        assertThat("Min element mismatch", minStack.getMin(), is(2));
        minStack.pop();
        assertThat("Min element mismatch", minStack.getMin(), is(2));
        minStack.pop();
        assertThat("Min element mismatch", minStack.getMin(), is(2));
        minStack.pop();

        assertThat("Min element mismatch", minStack.getMin(), is(3));
        minStack.pop();
        assertThat("Min element mismatch", minStack.getMin(), is(3));
        minStack.pop();

        assertThat("Min element mismatch", minStack.getMin(), is(4));
        minStack.pop();

        assertThat("Min element mismatch", minStack.getMin(), is(5));
        minStack.pop();
        assertThat("Min element mismatch", minStack.getMin(), is(5));
        minStack.pop();

        assertThat("Min element mismatch", minStack.getMin(), is(8));
        minStack.pop();
    }

}
