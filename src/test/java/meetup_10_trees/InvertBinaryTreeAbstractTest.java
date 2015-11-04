package meetup_10_trees;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_08_tree_traversal.adt.TreeNode;
import meetup_09_tree_traversal_serialization_depth.TreeSerializationCodec;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class InvertBinaryTreeAbstractTest {
    private TreeSerializationCodec codec = new TreeSerializationCodec();

    private InvertBinaryTree<Integer> inverter = createInverter();

    protected abstract InvertBinaryTree<Integer> createInverter();

    @Test
    @Parameters(method = "data")
    public void itShouldInvertBinaryTree(TreeNode<Integer> root,
                                         TreeNode<Integer> invertedRoot) {
        assertThat(inverter.invertTree(root), is(invertedRoot));
    }

    private Object[][] data() {
        return new Object[][]{
                {null, null},
                {codec.deserialize("[1]"), codec.deserialize("[1]")},
                {codec.deserialize("[1, 2]"), codec.deserialize("[1, #, 2]")},
                {codec.deserialize("[1, #, 3]"), codec.deserialize("[1, 3]")},

                {codec.deserialize("[4, 2, 7, 1, 3, 6, 9]"),
                        codec.deserialize("[4, 7, 2, 9, 6, 3, 1]")}
        };
    }

}
