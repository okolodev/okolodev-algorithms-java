package stack1.adt;

public class LinkedStackTest extends StackAbstractTest {

    @Override
    protected <E> Stack<E> createStack() {
        return new LinkedStack<>();
    }

}
