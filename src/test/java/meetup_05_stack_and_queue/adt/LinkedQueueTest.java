package meetup_05_stack_and_queue.adt;

public class LinkedQueueTest extends QueueAbstractTest {

    @Override
    protected Queue<Character> createQueue() {
        return new LinkedQueue<>();
    }

}
