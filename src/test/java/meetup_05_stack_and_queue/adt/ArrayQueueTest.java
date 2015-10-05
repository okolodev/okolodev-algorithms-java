package meetup_05_stack_and_queue.adt;

public class ArrayQueueTest extends QueueAbstractTest {

    @Override
    protected Queue<Character> createQueue() {
        return new ArrayQueue<>(4);
    }

}
