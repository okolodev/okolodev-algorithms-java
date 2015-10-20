package meetup_08_tree_traversal.applications;

public class PostOrderTraversalRecursivelyTest
        extends PostOrderTraversalAbstractTest {

    @Override
    protected PostOrderTraversal<Integer> createTraversal() {
        return new PostOrderTraversalRecursively();
    }

}
