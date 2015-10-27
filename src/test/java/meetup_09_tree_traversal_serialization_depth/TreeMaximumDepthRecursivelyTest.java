package meetup_09_tree_traversal_serialization_depth;

public class TreeMaximumDepthRecursivelyTest
        extends TreeMaximumDepthAbstractTest {

    @Override
    protected TreeMaximumDepth<Integer> createDepthFinder() {
        return new TreeMaximumDepthRecursively<>();
    }

}
