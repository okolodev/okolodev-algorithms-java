package meetup_08_tree_traversal.applications;

public class PreOrderTraversalRecursivelyTest
        extends PreOrderTraversalAbstractTest {

    @Override
    protected PreOrderTraversal<Integer> createTraversal() {
        return new PreOrderTraversalRecursively<>();
    }

}
