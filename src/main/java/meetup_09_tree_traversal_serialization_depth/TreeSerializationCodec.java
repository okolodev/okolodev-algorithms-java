package meetup_09_tree_traversal_serialization_depth;

import meetup_05_stack_and_queue.adt.LinkedQueue;
import meetup_05_stack_and_queue.adt.Queue;
import meetup_06_stack_queue_dynamic_array.adt.ArrayDynamicList;
import meetup_06_stack_queue_dynamic_array.adt.DynamicList;
import meetup_08_tree_traversal.adt.TreeNode;

/**
 * @see <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">Serialize and Deserialize Binary Tree</a>
 */
public class TreeSerializationCodec {
    private static final String NULL = "#";

    /**
     * Encodes a tree to a single string.
     *
     * @param root a tree to be encoded to a string.
     * @return an encoded string.
     */
    public String serialize(TreeNode<Integer> root) {
        if (root == null) {
            return "[]";
        }

        Queue<TreeNode<Integer>> nodes = new LinkedQueue<>();
        nodes.enqueue(root);

        int nonNullNodes = 1;

        DynamicList<Object> traversal = new ArrayDynamicList<>();

        while (nonNullNodes > 0) {
            TreeNode<Integer> current = nodes.dequeue();

            if (current == null) {
                traversal.add(NULL);

                continue;
            }

            traversal.add(current.getValue());
            nonNullNodes--;

            nodes.enqueue(current.getLeft());
            if (current.getLeft() != null) {
                nonNullNodes++;
            }

            nodes.enqueue(current.getRight());
            if (current.getRight() != null) {
                nonNullNodes++;
            }
        }

        return traversal.toString();
    }

    /**
     * Decodes your encoded data to tree.
     *
     * @param data a string to be encoded to a tree.
     * @return an encoded tree.
     */
    public TreeNode<Integer> deserialize(String data) {
        Queue<String> tokens = readTokens(data);

        if (tokens.isEmpty()) {
            return null;
        }

        Queue<TreeNode<Integer>> nodes = new LinkedQueue<>();
        int rootValue = Integer.parseInt(tokens.dequeue());
        TreeNode<Integer> root = new TreeNode<>(rootValue);
        nodes.enqueue(root);

        while (!tokens.isEmpty()) {
            TreeNode<Integer> current = nodes.dequeue();

            String leftToken = tokens.dequeue();

            if (!NULL.equals(leftToken)) {
                int leftValue = Integer.parseInt(leftToken);
                TreeNode<Integer> left = new TreeNode<>(leftValue);
                current.setLeft(left);
                nodes.enqueue(left);
            }

            if (!tokens.isEmpty()) {
                String rightToken = tokens.dequeue();

                if (!NULL.equals(rightToken)) {
                    int rightValue = Integer.parseInt(rightToken);
                    TreeNode<Integer> right = new TreeNode<>(rightValue);
                    current.setRight(right);
                    nodes.enqueue(right);
                }
            }
        }

        return root;
    }

    private Queue<String> readTokens(String data) {
        Queue<String> tokens = new LinkedQueue<>();
        String withoutBraces = data.substring(1, data.length() - 1);

        if (withoutBraces.isEmpty()) {
            return tokens;
        }

        for (String token : withoutBraces.split("\\s*,\\s*")) {
            tokens.enqueue(token);
        }

        return tokens;
    }

}
