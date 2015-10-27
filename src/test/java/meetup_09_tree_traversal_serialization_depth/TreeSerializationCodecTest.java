package meetup_09_tree_traversal_serialization_depth;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_08_tree_traversal.adt.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TreeSerializationCodecTest {
    private TreeSerializationCodec codec = new TreeSerializationCodec();

    @Test
    @Parameters(method = "dataSource")
    public void itShouldSerialiseTree(TreeNode<Integer> root, String data) {
        assertThat(codec.serialize(root), is(data));
    }

    @Test
    @Parameters(method = "dataSource")
    public void itShouldDeserialiseTree(TreeNode<Integer> root, String data) {
        assertThat(codec.deserialize(data), is(root));
    }

    private Object[][] dataSource() {
        return new Object[][]{
                {null, "[]"},

                {new TreeNode<>(1), "[1]"},

                {new TreeNode<>(new TreeNode<>(2), 1),
                        "[1, 2]"},
                {new TreeNode<>(1, new TreeNode<>(3)),
                        "[1, #, 3]"},

                {new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(3)),
                        "[1, 2, 3]"},

                {new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(new TreeNode<>(6), 3)),
                        "[1, 2, 3, #, #, 6]"},
                {new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(3, new TreeNode<>(7))),
                        "[1, 2, 3, #, #, #, 7]"},
                {new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(new TreeNode<>(6), 3, new TreeNode<>(7))),
                        "[1, 2, 3, #, #, 6, 7]"},


                {new TreeNode<>(new TreeNode<>(new TreeNode<>(4), 2), 1, new TreeNode<>(3)),
                        "[1, 2, 3, 4]"},
                {new TreeNode<>(new TreeNode<>(2, new TreeNode<>(5)), 1, new TreeNode<>(3)),
                        "[1, 2, 3, #, 5]"},
                {new TreeNode<>(new TreeNode<>(new TreeNode<>(4), 2, new TreeNode<>(5)),
                        1, new TreeNode<>(new TreeNode<>(6), 3, new TreeNode<>(7))),
                        "[1, 2, 3, 4, 5, 6, 7]"},

                {new TreeNode<>(new TreeNode<>(-2), -1, new TreeNode<>(-3)), "[-1, -2, -3]"}
        };
    }

}
