import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode solve(int prestart, int poststart, int preend, int[] preorder, int[] postorder,
                          Map<Integer, Integer> mp) {
        if (prestart > preend) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[prestart]);
        if (prestart == preend) {
            return root;
        }
        int nextNode = preorder[prestart + 1]; // root of left subtree

        int j = mp.get(nextNode);

        int num = j - poststart + 1;

        root.left = solve(prestart + 1, poststart, prestart + num, preorder, postorder, mp);
        root.right = solve(prestart + num + 1, j + 1, preend, preorder, postorder, mp);

        return root;
    }

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(postorder[i], i);
        }
        return solve(0, 0, n - 1, preorder, postorder, mp);
    }
}