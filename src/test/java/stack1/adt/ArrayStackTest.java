package stack1.adt;

import org.junit.Before;

public class ArrayStackTest extends StackAbstractTest {

    @Before
    public void setUp() {
        stack = new ArrayStack<>(10);
    }

}
