class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Count the number of times the order is broken
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // The array should have at most one break in order
        return count <= 1;
    }
}
