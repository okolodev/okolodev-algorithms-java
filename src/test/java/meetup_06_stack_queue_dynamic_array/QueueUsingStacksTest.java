package meetup_06_stack_queue_dynamic_array;

import meetup_05_stack_and_queue.adt.Queue;
import meetup_05_stack_and_queue.adt.QueueAbstractTest;

public class QueueUsingStacksTest extends QueueAbstractTest {

    @Override
    protected Queue<Character> createQueue() {
        return new QueueUsingStacks();
    }

}
