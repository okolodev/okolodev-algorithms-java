package meetup_10_trees;

public class SameTreeIterativelyTest extends SameTreeAbstractTest {

    @Override
    protected SameTree<Integer> createMatcher() {
        return new SameTreeIteratively<>();
    }

}
