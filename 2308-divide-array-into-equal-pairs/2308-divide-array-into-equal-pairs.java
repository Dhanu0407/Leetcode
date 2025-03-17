class Solution {
    public boolean divideArray(int[] nums) {
        int[] freq = new int[501]; // Array to store frequency of numbers

        for (int num : nums) {
            freq[num]++; // Count occurrences
        }

        for (int count : freq) {
            if (count % 2 != 0) {
                return false; // If any count is odd, we cannot pair all elements
            }
        }

        return true; // All numbers can be paired
    }
}
