package meetup_09_tree_traversal_serialization_depth;

public class TreeMaximumDepthIterativelyTest
        extends TreeMaximumDepthAbstractTest {

    @Override
    protected TreeMaximumDepth<Integer> createDepthFinder() {
        return new TreeMaximumDepthIteratively<>();
    }

}
