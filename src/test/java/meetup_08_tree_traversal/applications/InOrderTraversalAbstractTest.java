package meetup_08_tree_traversal.applications;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public abstract class InOrderTraversalAbstractTest
        extends TraversalAbstractTest {
    private InOrderTraversal<Integer> traversal = createTraversal();

    protected abstract InOrderTraversal<Integer> createTraversal();

    @Test
    @Parameters(method = "data")
    public void itShouldTraverseInOrder(TreeNode root, DynamicList<Integer> inorder) {
        assertThat(traversal.inOrderTraversal(root), is(inorder));
    }

    protected Object[][] data() {
        return new Object[][]{
                {null, asList()},

                {new TreeNode<>(1), asList(1)},

                {new TreeNode<>(new TreeNode<>(2), 1), asList(2, 1)},
                {new TreeNode<>(1, new TreeNode<>(2)), asList(1, 2)},

                {new TreeNode<>(new TreeNode<>(new TreeNode<>(3), 2), 1),
                        asList(3, 2, 1)},
                {new TreeNode<>(new TreeNode<>(2, new TreeNode<>(3)), 1),
                        asList(2, 3, 1)},
                {new TreeNode<>(1, new TreeNode<>(new TreeNode<>(3), 2)),
                        asList(1, 3, 2)},
                {new TreeNode<>(1, new TreeNode<>(2, new TreeNode<>(3))),
                        asList(1, 2, 3)},

                {new TreeNode<>(
                        new TreeNode<>(new TreeNode<>(4), 2, new TreeNode<>(5)),
                        1,
                        new TreeNode<>(new TreeNode<>(6), 3, new TreeNode<>(7))
                ),
                        asList(4, 2, 5, 1, 6, 3, 7)}
        };
    }

}
