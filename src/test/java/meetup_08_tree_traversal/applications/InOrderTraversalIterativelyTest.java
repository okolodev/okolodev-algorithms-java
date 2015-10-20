package meetup_08_tree_traversal.applications;

public class InOrderTraversalIterativelyTest
        extends InOrderTraversalAbstractTest {

    @Override
    protected InOrderTraversal<Integer> createTraversal() {
        return new InOrderTraversalIteratively<>();
    }

}
