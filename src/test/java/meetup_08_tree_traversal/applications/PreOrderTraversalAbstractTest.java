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
public abstract class PreOrderTraversalAbstractTest
        extends TraversalAbstractTest {
    private PreOrderTraversal<Integer> traversal = createTraversal();

    protected abstract PreOrderTraversal<Integer> createTraversal();

    @Test
    @Parameters(method = "data")
    public void itShouldTraversePreOrder(TreeNode root, DynamicList<Integer> preOrder) {
        assertThat(traversal.preOrderTraversal(root), is(preOrder));
    }

    private Object[][] data() {
        return new Object[][]{
                {null, asList()},

                {new TreeNode<>(1), asList(1)},

                {new TreeNode<>(new TreeNode<>(2), 1), asList(1, 2)},
                {new TreeNode<>(1, new TreeNode<>(2)), asList(1, 2)},

                {new TreeNode<>(new TreeNode<>(new TreeNode<>(3), 2), 1),
                        asList(1, 2, 3)},
                {new TreeNode<>(new TreeNode<>(2, new TreeNode<>(3)), 1),
                        asList(1, 2, 3)},
                {new TreeNode<>(1, new TreeNode<>(new TreeNode<>(3), 2)),
                        asList(1, 2, 3)},
                {new TreeNode<>(1, new TreeNode<>(2, new TreeNode<>(3))),
                        asList(1, 2, 3)},

                {new TreeNode<>(
                        new TreeNode<>(new TreeNode<>(4), 2, new TreeNode<>(5)),
                        1,
                        new TreeNode<>(new TreeNode<>(6), 3, new TreeNode<>(7))
                ),
                        asList(1, 2, 4, 5, 3, 6, 7)}
        };
    }

}
