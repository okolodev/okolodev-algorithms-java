package meetup_06_stack_queue_dynamic_array;

import stack1.adt.Stack;
import stack1.adt.StackAbstractTest;

public class StackUsingQueuesTest extends StackAbstractTest {

    @Override
    protected <E> Stack<E> createStack() {
        return new StackUsingQueues();
    }

}
