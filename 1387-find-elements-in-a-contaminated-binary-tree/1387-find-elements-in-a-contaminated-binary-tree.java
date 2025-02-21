import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

class FindElements {
    private Set<Integer> values; // HashSet for fast lookup

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recoverTree(root, 0); // Start recovering from root (0)
    }

    private void recoverTree(TreeNode node, int value) {
        if (node == null) return;
        
        node.val = value; // Assign correct value to the node
        values.add(value); // Store it in the set

        // Recursively assign values to left and right children
        recoverTree(node.left, 2 * value + 1);
        recoverTree(node.right, 2 * value + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}
