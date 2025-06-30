import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count the frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLen = 0;

        // Check for harmonious subsequences
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int currentLen = map.get(key) + map.get(key + 1);
                maxLen = Math.max(maxLen, currentLen);
            }
        }

        return maxLen;
    }
}
