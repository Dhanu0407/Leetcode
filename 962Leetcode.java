class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();

        // Step 1: Fill the stack with indices of nums in increasing order
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        // Step 2: Traverse from right to left
        for (int j = n - 1; j >= 0; j--) {
            // While there are indices in the stack and nums[stack.peek()] <= nums[j]
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxWidthRamp(new int[]{6, 0, 8, 2, 1, 5}));  // Output: 4
        System.out.println(solution.maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));  // Output: 7
    }
}
