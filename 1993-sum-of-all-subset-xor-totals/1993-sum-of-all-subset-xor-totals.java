class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }
    
    private int helper(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        // Two choices: 
        // 1. Include nums[index] in XOR
        int withCurrent = helper(nums, index + 1, currentXOR ^ nums[index]);
        // 2. Exclude nums[index]
        int withoutCurrent = helper(nums, index + 1, currentXOR);
        
        return withCurrent + withoutCurrent;
    }
}
