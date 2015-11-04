package meetup_10_trees;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;
import meetup_09_tree_traversal_serialization_depth.TreeSerializationCodec;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class BinaryTreeRightSideViewTest {
    private TreeSerializationCodec codec = new TreeSerializationCodec();

    private BinaryTreeRightSideView<Integer> rightSideView =
            new BinaryTreeRightSideView<>();

    @Test
    @Parameters(method = "data")
    public void itShouldProvideRightSideViewNodes(TreeNode<Integer> root,
                                                  DynamicList<Integer> list) {
        assertThat(rightSideView.rightSideView(root), is(list));
    }

    private Object[][] data() {
        return new Object[][]{
                {null, asList()},
                {codec.deserialize("[1]"), asList(1)},
                {codec.deserialize("[1, 2]"), asList(1, 2)},
                {codec.deserialize("[1, #, 3]"), asList(1, 3)},
                {codec.deserialize("[1, 2, 3]"), asList(1, 3)},
                {codec.deserialize("[1, 2, 3, #, 5, #, 6]"),
                        asList(1, 3, 6)},
                {codec.deserialize("[1, 2, 3, #, 5, #, 6, 7]"),
                        asList(1, 3, 6, 7)}
        };
    }

    private <E> DynamicList<E> asList(E... elements) {
        return new ArrayDynamicList<>(elements);
    }

}
