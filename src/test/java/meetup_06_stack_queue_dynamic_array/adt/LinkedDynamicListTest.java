package meetup_06_stack_queue_dynamic_array.adt;

public class LinkedDynamicListTest extends DynamicListAbstractTest {

    @Override
    protected <E> DynamicList<E> createList() {
        return new LinkedDynamicList<>();
    }

}
