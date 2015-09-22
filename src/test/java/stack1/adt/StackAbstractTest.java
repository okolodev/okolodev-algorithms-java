package stack1.adt;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public abstract class StackAbstractTest {
    protected Stack<Integer> stack;

    // is empty
    @Test
    public void itShouldBeEmptyWhenCreated() {
        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void itShouldNotBeEmptyWhenAnElementWasAdded() {
        stack.push(1);

        assertThat(stack.isEmpty(), is(false));
    }

    // peek
    @Test
    public void itShouldBePeekPushedElement() {
        Integer element = 2;

        stack.push(element);


        assertThat(stack.peek(), is(element));
    }

    @Test
    public void peekingSingleElementShouldNotMakeStackEmpty() {
        stack.push(4);

        stack.peek();

        assertThat(stack.isEmpty(), is(false));
    }

    @Test
    public void peekShouldBeIdempotent() {
        Integer element = 3;

        stack.push(element);

        assertThat(stack.peek(), is(stack.peek()));
    }

    // pop
    @Test
    public void itShouldPushAndPopElement() {
        Integer element = 5;

        stack.push(element);

        assertThat(stack.pop(), is(element));
    }

    @Test
    public void poppingSingleElementShouldMakeStackEmpty() {
        Integer element = 6;

        stack.push(element);
        stack.pop();

        assertThat(stack.isEmpty(), is(true));
    }

    @Test
    public void itShouldWorkLastInFirstOut() {
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(stack.peek(), is(3));
        assertThat(stack.pop(), is(3));

        assertThat(stack.peek(), is(2));
        assertThat(stack.pop(), is(2));

        assertThat(stack.peek(), is(1));
        assertThat(stack.pop(), is(1));
    }

}
