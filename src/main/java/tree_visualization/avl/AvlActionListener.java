package tree_visualization.avl;

import meetup_08_tree_traversal.adt.TreeNode;
import meetup_18_unbalanced_binary_search_tree.BinarySearchTree;
import meetup_21_avl_tree.AvlBinarySearchTree;
import tree_visualization.TreePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public abstract class AvlActionListener implements ActionListener {
    private final TreePanel treePanel;
    private final JTextField valueField;
    private final JFrame frame;
    private final Color contentsTextFieldBackground;
    private final AvlBinarySearchTree<Integer> tree;

    public AvlActionListener(TreePanel treePanel,
                             JTextField valueField,
                             JFrame frame,
                             AvlBinarySearchTree<Integer> tree) {
        this.treePanel = treePanel;
        this.valueField = valueField;
        contentsTextFieldBackground = valueField.getBackground();
        this.frame = frame;
        this.tree = tree;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String valueText = valueField.getText();

        List<Integer> values = new ArrayList<>();
        try {
            for (String token : valueText.split("\\D+")) {
                if (!token.isEmpty()) {
                    values.add(Integer.valueOf(token));
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            valueField.setToolTipText(e.toString());
            valueField.setBackground(Color.RED);
            return;
        }

        for (Integer value : values) {
            updateTree(tree, value);
        }

        TreeNode<Integer> root = tree.toBinaryTree();
        treePanel.setTree(root);

        valueField.setToolTipText("");
        valueField.setBackground(contentsTextFieldBackground);

        frame.revalidate();
        frame.repaint();
    }

    protected abstract void updateTree(BinarySearchTree<Integer> tree, int value);

}
