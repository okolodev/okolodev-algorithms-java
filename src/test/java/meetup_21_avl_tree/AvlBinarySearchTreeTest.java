package meetup_21_avl_tree;

import junitparams.Parameters;
import meetup_08_tree_traversal.adt.TreeNode;
import meetup_18_unbalanced_binary_search_tree.BinarySearchTreeAbstractTest;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class AvlBinarySearchTreeTest extends BinarySearchTreeAbstractTest {
    private AvlBinarySearchTree<Character> avlTree = createBinarySearchTree();

    @Override
    protected AvlBinarySearchTree<Character> createBinarySearchTree() {
        return new AvlBinarySearchTree<>();
    }

    @Test
    public void toBinaryTreeShouldReturnNullOnEmptyAvlBinarySearchTree() {
        assertThat(avlTree.toBinaryTree(), is(nullValue()));
    }

    @Test
    @Parameters(method = "leftLeftCases")
    public void itShouldReBalanceLeftLeftCase(Character[] values,
                                              TreeNode<Character> tree) {
        Arrays.stream(values).forEach(avlTree::insert);

        assertThat(avlTree.toBinaryTree(), is(tree));
    }

    private Object[][] leftLeftCases() {
        return new Object[][]{
                {new Character[]{'C', 'B', 'A'},
                        n(n('A'), 'B', n('C'))}
        };
    }

    @Test
    @Parameters(method = "leftRightCases")
    public void itShouldReBalanceLeftRightCase(Character[] values,
                                               TreeNode<Character> tree) {
        Arrays.stream(values).forEach(avlTree::insert);

        assertThat(avlTree.toBinaryTree(), is(tree));
    }

    private Object[][] leftRightCases() {
        return new Object[][]{
                {new Character[]{'C', 'A', 'B'},
                        n(n('A'), 'B', n('C'))}
        };
    }

    @Test
    @Parameters(method = "rightRightCases")
    public void itShouldReBalanceRightRightCase(Character[] values,
                                                TreeNode<Character> tree) {
        Arrays.stream(values).forEach(avlTree::insert);

        assertThat(avlTree.toBinaryTree(), is(tree));
    }

    private Object[][] rightRightCases() {
        return new Object[][]{
                {new Character[]{'A', 'B', 'C'},
                        n(n('A'), 'B', n('C'))}
        };
    }

    @Test
    @Parameters(method = "rightLeftCases")
    public void itShouldReBalanceRightLeftCase(Character[] values,
                                               TreeNode<Character> tree) {
        Arrays.stream(values).forEach(avlTree::insert);

        assertThat(avlTree.toBinaryTree(), is(tree));
    }

    private Object[][] rightLeftCases() {
        return new Object[][]{
                {new Character[]{'A', 'C', 'B'},
                        n(n('A'), 'B', n('C'))}
        };
    }

    @Test
    @Parameters(method = "insertCases")
    public void itShouldReBalanceOnInsertion(Character[] values,
                                             TreeNode<Character> tree) {
        Arrays.stream(values).forEach(avlTree::insert);

        assertThat(avlTree.toBinaryTree(), is(tree));
    }

    private Object[][] insertCases() {
        return new Object[][]{
                {new Character[]{'1', '2', '3', '4', '5', '6', '7'},
                        n(n(n('1'), '2', n('3')), '4', n(n('5'), '6', n('7')))},
                {new Character[]{'1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'},
                        n(
                                n(n(n('1'), '2', n('3')), '4', n(n('5'), '6', n('7'))),
                                '8',
                                n(n(n('9'), 'A', n('B')), 'C', n(n('D'), 'E', n('F')))
                        )}
        };
    }

    @Test
    @Parameters(method = "removeCases")
    public void itShouldReBalanceOnRemoval(Character[] values,
                                           Character[] removeValues,
                                           TreeNode<Character> tree) {
        Arrays.stream(values).forEach(avlTree::insert);

        Arrays.stream(removeValues).forEach(avlTree::remove);

        TreeNode<Character> actual = avlTree.toBinaryTree();
        assertThat(actual, is(tree));
    }

    private Object[][] removeCases() {
        return new Object[][]{
                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'1'},
                        n(n('2', n('3')), '4', n('5'))},
                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'2'},
                        n(n('1'), '3', n('4', n('5')))},
                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'3'},
                        n(n('1'), '2', n('4', n('5')))},
                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'4'},
                        n(n('1'), '2', n(n('3'), '5'))},
                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'5'},
                        n(n('1'), '2', n(n('3'), '4'))},

                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'1', '2'},
                        n(n('3'), '4', n('5'))},
                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'4', '5'},
                        n(n('1'), '2', n('3'))},
                {new Character[]{'1', '2', '3', '4', '5'},
                        new Character[]{'2', '3'},
                        n(n('1'), '4', n('5'))},
                {new Character[]{'1', '2', '3', '4', '5', '6'},
                        new Character[]{'3', '2', '4'},
                        n(n('1'), '5', n('6'))}
        };
    }

    private TreeNode<Character> n(Character value) {
        return new TreeNode<>(value);
    }

    private TreeNode<Character> n(TreeNode<Character> left,
                                  Character value) {
        return new TreeNode<>(left, value);
    }

    private TreeNode<Character> n(Character value,
                                  TreeNode<Character> right) {
        return new TreeNode<>(value, right);
    }

    private TreeNode<Character> n(TreeNode<Character> left,
                                  Character value,
                                  TreeNode<Character> right) {
        return new TreeNode<>(left, value, right);
    }

}
