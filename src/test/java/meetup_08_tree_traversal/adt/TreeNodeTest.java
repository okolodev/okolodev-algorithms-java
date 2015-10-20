package meetup_08_tree_traversal.adt;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class TreeNodeTest {

    @Test
    public void itShouldHaveValue() {
        TreeNode<Integer> root = new TreeNode<>(1);

        assertThat(root.getValue(), is(1));
    }

    @Test
    public void itShouldHaveNoLeftChildWhenCreated() {
        TreeNode<Integer> root = new TreeNode<>(0);

        assertThat(root.getLeft(), is(nullValue()));
    }

    @Test
    public void itShouldHaveLeftChildWhenSet() {
        TreeNode<Integer> root = new TreeNode<>(0);

        TreeNode<Integer> left = new TreeNode<>(2);
        root.setLeft(left);

        assertThat(root.getLeft(), is(sameInstance(left)));
    }

    @Test
    public void itShouldHaveNoRightChildWhenCreated() {
        TreeNode<Integer> root = new TreeNode<>(0);

        assertThat(root.getRight(), is(nullValue()));
    }

    @Test
    public void itShouldHaveRightChildWhenSet() {
        TreeNode<Integer> root = new TreeNode<>(0);

        TreeNode<Integer> right = new TreeNode<>(3);
        root.setRight(right);

        assertThat(root.getRight(), is(sameInstance(right)));
    }

    @Test
    @Parameters(method = "equalTrees")
    public void itShouldBeEqual(TreeNode<Integer> rootA,
                                TreeNode<Integer> rootB) {
        assertThat(rootA, is(rootB));
    }

    private Object[][] equalTrees() {
        TreeNode<Integer> singleton = new TreeNode<>(1);

        return new Object[][]{
                {singleton, singleton},

                {new TreeNode<>(new TreeNode<>(2), 1),
                        new TreeNode<>(new TreeNode<>(2), 1)},
                {new TreeNode<>(1, new TreeNode<>(3)),
                        new TreeNode<>(1, new TreeNode<>(3))},

                {new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(3)),
                        new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(3))}
        };
    }

    @Test
    @Parameters(method = "notEqualTrees")
    public void itShouldNotBeEqual(TreeNode<Integer> rootA,
                                   TreeNode<Integer> rootB) {
        assertThat(rootA, is(not(rootB)));
    }

    private Object[][] notEqualTrees() {
        return new Object[][]{
                {null, new TreeNode<>(2)},

                {new TreeNode<>(1), new TreeNode<>(2)},

                {new TreeNode<>(new TreeNode<>(1), 2),
                        new TreeNode<>(new TreeNode<>(2), 1)},
                {new TreeNode<>(new TreeNode<>(2), 1),
                        new TreeNode<>(new TreeNode<>(1), 2)},

                {new TreeNode<>(1, new TreeNode<>(3)),
                        new TreeNode<>(3, new TreeNode<>(1))},
                {new TreeNode<>(3, new TreeNode<>(1)),
                        new TreeNode<>(1, new TreeNode<>(3))},

                {new TreeNode<>(new TreeNode<>(3), 1, new TreeNode<>(2)),
                        new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(3))},
                {new TreeNode<>(new TreeNode<>(2), 1, new TreeNode<>(3)),
                        new TreeNode<>(new TreeNode<>(3), 1, new TreeNode<>(1))}
        };
    }

}
