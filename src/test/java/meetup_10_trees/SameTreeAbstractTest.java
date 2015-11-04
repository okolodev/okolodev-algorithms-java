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
public abstract class SameTreeAbstractTest {
    private TreeSerializationCodec codec = new TreeSerializationCodec();
    private SameTree<Integer> matcher = createMatcher();

    protected abstract SameTree<Integer> createMatcher();

    @Test
    @Parameters(method = "same")
    public void itShouldBeSameTree(TreeNode<Integer> firstTree,
                                   TreeNode<Integer> secondTree) {
        assertThat(matcher.isSameTree(firstTree, secondTree), is(true));
    }

    private Object[][] same() {
        return new Object[][]{
                {null, null},

                {codec.deserialize("[1]"), codec.deserialize("[1]")},
                {codec.deserialize("[1, 2]"), codec.deserialize("[1, 2]")},
                {codec.deserialize("[1, #, 3]"), codec.deserialize("[1, #, 3]")},
                {codec.deserialize("[1, 2, 3]"), codec.deserialize("[1, 2, 3]")},

                {codec.deserialize("[1, #, 3, 4, #, #, 5, 6, 7]"),
                        codec.deserialize("[1, #, 3, 4, #, #, 5, 6, 7]")},
        };
    }

    @Test
    @Parameters(method = "different")
    public void itShouldNotBeSameTree(TreeNode<Integer> firstTree,
                                      TreeNode<Integer> secondTree) {
        assertThat(matcher.isSameTree(firstTree, secondTree), is(false));
    }

    private Object[][] different() {
        return new Object[][]{
                {null, codec.deserialize("[1]")},
                {codec.deserialize("[1]"), null},

                {codec.deserialize("[1]"), codec.deserialize("[0]")},
                {codec.deserialize("[1, 2]"), codec.deserialize("[1, 0]")},
                {codec.deserialize("[1, 2, 3]"), codec.deserialize("[1, 2]")},
                {codec.deserialize("[1, 2, 3]"), codec.deserialize("[1, #, 3]")},
                {codec.deserialize("[1, #, 3]"), codec.deserialize("[1, #, 5]")},
                {codec.deserialize("[1, 2, 3]"), codec.deserialize("[1, 3, 2]")},

                {codec.deserialize("[1, #, 3, 4, #, #, 5, 6, 7]"),
                        codec.deserialize("[1, #, 3, 4, #, #, 5, 6, 8]")},

                {codec.deserialize("[1, 2]"), codec.deserialize("[1, #, 2]")}
        };
    }

}
