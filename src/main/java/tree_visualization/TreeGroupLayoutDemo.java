package tree_visualization;

import meetup_08_tree_traversal.adt.TreeNode;
import meetup_09_tree_traversal_serialization_depth.TreeSerializationCodec;

import javax.swing.*;
import java.awt.*;

public class TreeGroupLayoutDemo {
    public static boolean RIGHT_TO_LEFT = false;

    public static void addComponentsToPane(GroupLayout layout) {
        JLabel contentsLabel = new JLabel("Tree contents:");
        JTextField contentsTextField = new JTextField("field");

        Insets buttonMargin = new Insets(0, 0, 0, 0);
        JButton serializeButton = new JButton("Serialize");
        serializeButton.setMargin(buttonMargin);
        JButton deserializeButton = new JButton("Deserialize");
        deserializeButton.setMargin(buttonMargin);

        TreeSerializationCodec codec = new TreeSerializationCodec();
        TreeNode<Integer> tree = codec.deserialize("[3,9,20,#,#,15,7]");
        TreePanel treePanel = new TreePanel(tree);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
//                        .addGroup(layout.createSequentialGroup()
//                                .addComponent(contentsLabel)
//                                .addComponent(contentsTextField)
//                                .addComponent(serializeButton)
//                                .addComponent(deserializeButton))
                        .addComponent(treePanel)));

        layout.setVerticalGroup(layout.createSequentialGroup()
//                .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
//                                .addComponent(contentsLabel)
//                                .addComponent(contentsTextField)
//                                .addComponent(serializeButton)
//                                .addComponent(deserializeButton)))
                .addComponent(treePanel));
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Tree GroupLayoutDemo");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        GroupLayout layout = new GroupLayout(contentPane);
        contentPane.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        addComponentsToPane(layout);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
