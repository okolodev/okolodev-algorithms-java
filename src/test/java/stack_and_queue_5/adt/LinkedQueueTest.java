package stack_and_queue_5.adt;

public class LinkedQueueTest extends QueueAbstractTest {

    @Override
    protected Queue<Character> createQueue() {
        return new LinkedQueue<>();
    }

}
