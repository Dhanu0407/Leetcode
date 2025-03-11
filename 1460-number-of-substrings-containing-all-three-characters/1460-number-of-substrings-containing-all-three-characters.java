class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[3]; // To store frequency of 'a', 'b', 'c'
        int l = 0, res = 0;

        for (int r = 0; r < n; r++) {
            count[s.charAt(r) - 'a']++;

            // If all characters a, b, c are in the window, shrink from the left
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += n - r; // Every valid window adds (n - r) substrings
                count[s.charAt(l) - 'a']--; 
                l++; // Move left pointer to explore new windows
            }
        }
        return res;
    }
}
