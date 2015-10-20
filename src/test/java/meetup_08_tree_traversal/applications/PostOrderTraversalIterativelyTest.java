package meetup_08_tree_traversal.applications;

public class PostOrderTraversalIterativelyTest
        extends PostOrderTraversalAbstractTest {

    @Override
    protected PostOrderTraversal<Integer> createTraversal() {
        return new PostOrderTraversalIteratively<>();
    }

}
