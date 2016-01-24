package tree_visualization;

import meetup_08_tree_traversal.adt.TreeNode;

import javax.swing.*;
import java.awt.*;

public class TreePanel extends JPanel {
    private final int cellSize = 24;
    private final int treeHeight;
    private final int canvasWidth;
    private final int canvasHeight;
    private TreeNode<Integer> root;

    public TreePanel() {
        this.treeHeight = 5;
        canvasWidth = cellSize * widthMultiplier(treeHeight);
        canvasHeight = cellSize * treeHeight * 2;

        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    public TreePanel(TreeNode<Integer> root) {
        this();
        this.root = root;
    }

    public void setTree(TreeNode<Integer> root) {
        this.root = root;
    }

    private int widthMultiplier(int level) {
        return 1 << level;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        setBorder(BorderFactory.createLineBorder(Color.black)); 100% CPU
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));

        drawTree(g);
    }

    private void drawTree(Graphics g) {
        Font font = new Font("Monospace, Consolas", Font.BOLD, cellSize - 2);
        g.setFont(font);
        drawTree(g, root, null, 0, canvasWidth, 0);
    }

    private void drawTree(Graphics g, TreeNode<Integer> node, TreeNode<Integer> parent, int minX, int maxX, int level) {
        if (node == null) {
            return;
        }

        int d = cellSize;
        int x = minX + (maxX - minX) / 2;
        int y = cellSize * level * 2;

//        g.drawOval(x - d / 2, y, d, d);
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
