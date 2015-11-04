package meetup_10_trees;

public class SameTreeRecursivelyTest extends SameTreeAbstractTest {

    @Override
    protected SameTree<Integer> createMatcher() {
        return new SameTreeRecursively<>();
    }

}
