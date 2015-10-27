package meetup_09_tree_traversal_serialization_depth;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;
import meetup_08_tree_traversal.applications.TraversalAbstractTest;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class LevelOrderTraversalLeetcodeTest extends TraversalAbstractTest {
    private LevelOrderTraversalLeetcode<Integer> traversal =
            new LevelOrderTraversalLeetcode<>();

    @Test
    @Parameters(method = "data")
    public void itShouldLevelOrderTraversal(TreeNode<Integer> root,
                                            DynamicList<DynamicList<Integer>> levelOrder) {
        assertThat(traversal.levelOrderTraversal(root), is(levelOrder));
    }

    private Object[][] data() {
        TreeSerializationCodec codec = new TreeSerializationCodec();

        return new Object[][]{
                {null, new ArrayDynamicList<>()},

                {codec.deserialize("[1]"), asList(asList(1))},

                {codec.deserialize("[1, 2]"), asList(asList(1), asList(2))},
                {codec.deserialize("[1, #, 3]"), asList(asList(1), asList(3))},
                {codec.deserialize("[1, 2, 3]"), asList(asList(1), asList(2, 3))},

                {codec.deserialize("[3,9,20,#,#,15,7]"),
                        asList(asList(3), asList(9, 20), asList(15, 7))},
        };
    }

}
