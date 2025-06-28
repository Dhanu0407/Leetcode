import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Pair class to hold value and index
        class Pair {
            int val, idx;
            Pair(int val, int idx) {
                this.val = val;
                this.idx = idx;
            }
        }

        // Create array of pairs
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        // Sort by value descending
        Arrays.sort(pairs, (a, b) -> b.val - a.val);

        // Take top k elements
        List<Pair> topK = Arrays.asList(Arrays.copyOf(pairs, k));

        // Sort top k by original index to maintain subsequence order
        topK.sort(Comparator.comparingInt(a -> a.idx));

        // Build the result array
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = topK.get(i).val;
        }

        return result;
    }
}
