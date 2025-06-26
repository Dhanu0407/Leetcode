class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int n = s.length();
        int zeroCount = 0;

        // First pass: Count all zeros
        for (char c : s.toCharArray()) {
            if (c == '0') count++;
        }

        long value = 0;
        int bit = 0;

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                if (bit < 32) {
                    value += 1L << bit;
                    if (value <= k) {
                        count++;
                        bit++;
                    } else {
                        // Remove the added value and stop checking further
                        value -= 1L << bit;
                    }
                } else {
                    break; // Bit exceeds 32, risk of overflow
                }
            } else {
                // Already counted all '0's
                bit++;
            }
        }

        return count;
    }
}
