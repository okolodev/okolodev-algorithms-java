package meetup_09_tree_traversal_serialization_depth;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_08_tree_traversal.adt.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class TreeMaximumDepthAbstractTest {
    private TreeMaximumDepth<Integer> depthFinder = createDepthFinder();

    protected abstract TreeMaximumDepth<Integer> createDepthFinder();

    @Test
    @Parameters(method = "data")
    public void itShouldFindMaximumTreeDepth(TreeNode<Integer> root,
                                             int depth) {
        assertThat(depthFinder.maxDepth(root), is(depth));
    }

    private Object[][] data() {
        TreeSerializationCodec codec = new TreeSerializationCodec();

        return new Object[][]{
                {null, 0},

                {codec.deserialize("[1]"), 1},

                {codec.deserialize("[1, 2]"), 2},
                {codec.deserialize("[1, #, 3]"), 2},
                {codec.deserialize("[1, 2, 3]"), 2},

                {codec.deserialize("[3,9,20,#,#,15,7]"), 3},
        };
    }

}
