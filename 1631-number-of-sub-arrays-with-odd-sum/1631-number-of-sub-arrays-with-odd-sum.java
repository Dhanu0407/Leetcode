class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;
        int oddCount = 0, evenCount = 1; // Start with evenCount = 1 for initial empty prefix
        int prefixSum = 0, result = 0;

        for (int num : arr) {
            prefixSum += num;
            
            if (prefixSum % 2 == 0) { // Even prefix sum
                result = (result + oddCount) % MOD;
                evenCount++;
            } else { // Odd prefix sum
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }
        
        return result;
    }
}
