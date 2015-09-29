package stack_and_queue_5.adt;

public class ArrayQueueTest extends QueueAbstractTest {

    @Override
    protected Queue<Character> createQueue() {
        return new ArrayQueue<>(4);
    }

}
