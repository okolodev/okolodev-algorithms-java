package tree_visualization;

import meetup_08_tree_traversal.adt.TreeNode;
import meetup_09_tree_traversal_serialization_depth.TreeSerializationCodec;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeserializeActionListener implements ActionListener {
    private final TreePanel treePanel;
    private final JTextField contentsTextField;
    private final JFrame frame;
    private final TreeSerializationCodec codec = new TreeSerializationCodec();
    private final Color contentsTextFieldBackground;

    public DeserializeActionListener(TreePanel treePanel,
                                     JTextField contentsTextField,
                                     JFrame frame) {
        this.treePanel = treePanel;
        this.contentsTextField = contentsTextField;
        contentsTextFieldBackground = contentsTextField.getBackground();
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String serializedTree = contentsTextField.getText();

        try {
            TreeNode<Integer> root = codec.deserialize(serializedTree);
            treePanel.setTree(root);

            contentsTextField.setToolTipText("");
            contentsTextField.setBackground(contentsTextFieldBackground);

            frame.revalidate();
            frame.repaint();
        } catch (RuntimeException e) {
            e.printStackTrace();
            contentsTextField.setToolTipText(e.toString());
            contentsTextField.setBackground(Color.RED);
        }
    }

}
