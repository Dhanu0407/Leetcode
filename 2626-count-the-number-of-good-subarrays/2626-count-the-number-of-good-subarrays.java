import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        long result = 0;
        long pairs = 0;
        int left = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < nums.length; right++) {
            int count = freq.getOrDefault(nums[right], 0);
            pairs += count; // Add count of existing same numbers
            freq.put(nums[right], count + 1);

            while (pairs >= k) {
                result += nums.length - right; // all subarrays from left to end
                int leftCount = freq.get(nums[left]);
                pairs -= leftCount - 1; // removing left element reduces pairs
                freq.put(nums[left], leftCount - 1);
                left++;
            }
        }
        return result;
    }
}
