class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();
        
        // Cantor's Diagonalization: Flip the i-th character of the i-th string
        for (int i = 0; i < n; i++) {
            // Flip '0' to '1' and '1' to '0'
            result.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        
        return result.toString();
    }
}
