package meetup_10_trees;

public class InvertBinaryTreeIterativelyTest
        extends InvertBinaryTreeAbstractTest {

    @Override
    protected InvertBinaryTree<Integer> createInverter() {
        return new InvertBinaryTreeIteratively<>();
    }

}
