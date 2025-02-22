import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;

            // Count number of dashes to determine depth
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Extract the node value
            int value = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            // Create a new node
            TreeNode node = new TreeNode(value);

            // Maintain stack depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // Attach the node to its parent
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            // Push the current node onto the stack
            stack.push(node);
        }

        // The root of the tree is at the bottom of the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
