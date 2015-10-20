package meetup_08_tree_traversal.applications;

public class PreOrderTraversalIterativelyTest
        extends PreOrderTraversalAbstractTest {

    @Override
    protected PreOrderTraversal<Integer> createTraversal() {
        return new PreOrderTraversalIteratively<>();
    }

}
