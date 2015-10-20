package meetup_08_tree_traversal.applications;

public class InOrderTraversalRecursivelyTest
        extends InOrderTraversalAbstractTest {

    @Override
    protected InOrderTraversal<Integer> createTraversal() {
        return new InOrderTraversalRecursively<>();
    }

}
