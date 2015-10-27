package tree_visualization;

import meetup_08_tree_traversal.adt.TreeNode;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private final int cellSize = 20;
    private final int treeHeight;
    private final int canvasWidth;
    private final int canvasHeight;
    private final TreeNode<Integer> root;

    public TreePanel(TreeNode<Integer> root) {
        this.root = root;
        this.treeHeight = 5;
        canvasWidth = cellSize * widthMultiplier(treeHeight);
        canvasHeight = cellSize * treeHeight * 2;

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    private int widthMultiplier(int level) {
        return 1 << level;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        setBorder(BorderFactory.createLineBorder(Color.black));

        drawTree(g);
    }

    private void drawTree(Graphics g) {
        g.setFont(new Font("Tahoma", Font.PLAIN, 16));
        drawTree(g, root, null, 0, canvasWidth, 0);
    }

    private void drawTree(Graphics g, TreeNode<Integer> node, TreeNode<Integer> parent, int minX, int maxX, int level) {
        if (node == null) {
            return;
        }

        int d = cellSize;
        int x = minX + (maxX - minX) / 2;
        int y = cellSize * level * 2;

        g.drawOval(x - d / 2, y, d, d);
        g.drawString(String.valueOf(node.getValue()), x - d / 4, (int) (y + d / 1.25));

        if (parent != null) {
            int parentY = cellSize * (level - 1) * 2 + cellSize;
            int parentX = maxX;

            if (node == parent.getRight()) {
                parentX = minX;
            }

            g.drawLine(x, y, parentX, parentY);
        }

        drawTree(g, node.getLeft(), node, minX, x, level + 1);
        drawTree(g, node.getRight(), node, x, maxX, level + 1);
    }

}
