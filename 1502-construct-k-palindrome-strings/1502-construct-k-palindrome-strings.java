import java.util.HashMap;

class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than the length of the string, it's impossible
        if (k > s.length()) {
            return false;
        }
        
        // Count the frequency of each character
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Count the number of odd frequencies
        int oddCount = 0;
        for (int count : charCount.values()) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // We can form k palindromes if oddCount <= k
        return oddCount <= k;
    }
}
