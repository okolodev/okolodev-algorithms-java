package meetup_10_trees;

import meetup_08_tree_traversal.adt.TreeNode;

import java.util.Objects;

public class SameTreeRecursively<E> implements SameTree<E> {

    @Override
    public boolean isSameTree(TreeNode<E> firstTree,
                              TreeNode<E> secondTree) {
        if (firstTree == null && secondTree == null) {
            return true;
        } else if (firstTree == null ^ secondTree == null) {
            return false;
        }

        if (!Objects.equals(firstTree.getValue(), secondTree.getValue())) {
            return false;
        }

        return isSameTree(firstTree.getLeft(), secondTree.getLeft())
                && isSameTree(firstTree.getRight(), secondTree.getRight());
    }

}
