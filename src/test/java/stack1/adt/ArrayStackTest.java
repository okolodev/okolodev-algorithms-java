package stack1.adt;

public class ArrayStackTest extends StackAbstractTest {

    @Override
    protected <E> Stack<E> createStack() {
        return new ArrayStack<>(10);
    }

}
