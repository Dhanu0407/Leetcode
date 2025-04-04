class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return helper(root).lca;
    }
    
    // Helper class to store the LCA and depth
    class Result {
        TreeNode lca;
        int depth;
        
        Result(TreeNode node, int d) {
            this.lca = node;
            this.depth = d;
        }
    }
    
    private Result helper(TreeNode node) {
        if (node == null) {
            return new Result(null, 0);
        }
        
        Result left = helper(node.left);
        Result right = helper(node.right);
        
        if (left.depth == right.depth) {
            return new Result(node, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Result(left.lca, left.depth + 1);
        } else {
            return new Result(right.lca, right.depth + 1);
        }
    }
}
