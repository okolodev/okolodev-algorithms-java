package meetup_08_tree_traversal.applications;

import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;

public abstract class TraversalAbstractTest {

    public <T> DynamicList<T> asList(T... elements) {
        return new ArrayDynamicList<>(elements);
    }

}
