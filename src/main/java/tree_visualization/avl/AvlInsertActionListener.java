package tree_visualization.avl;

import meetup_18_unbalanced_binary_search_tree.BinarySearchTree;
import meetup_21_avl_tree.AvlBinarySearchTree;
import tree_visualization.TreePanel;

import javax.swing.*;

public class AvlInsertActionListener extends AvlActionListener {

    public AvlInsertActionListener(TreePanel treePanel,
                                   JTextField valueField,
                                   JFrame frame,
                                   AvlBinarySearchTree<Integer> tree) {
        super(treePanel, valueField, frame, tree);
    }

    @Override
    protected void updateTree(BinarySearchTree<Integer> tree, int value) {
        tree.insert(value);
    }

}
