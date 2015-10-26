package meetup_06_stack_queue_dynamic_array.adt;

public class LinkedDynamicListTest extends DynamicListAbstractTest {

    @Override
    protected <E> DynamicList<E> createList() {
        return new LinkedDynamicList<>();
    }

    @Override
    protected <E> DynamicList<E> createList(E... elements) {
        return new LinkedDynamicList<>(elements);
    }

}
