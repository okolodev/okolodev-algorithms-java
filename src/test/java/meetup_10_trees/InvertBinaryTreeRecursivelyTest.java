package meetup_10_trees;

public class InvertBinaryTreeRecursivelyTest
        extends InvertBinaryTreeAbstractTest {

    @Override
    protected InvertBinaryTree<Integer> createInverter() {
        return new InvertBinaryTreeRecursively<>();
    }

}
