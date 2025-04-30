class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int digitCount = String.valueOf(num).length();
            if (digitCount % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
